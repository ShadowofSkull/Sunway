import discord
import os
from discord.ext import commands
from bs4 import BeautifulSoup
import requests
import csv
import math

# replace USER_AGENT & BOTKEY with your own user agent and discord bot key
# this is done this way as replit has a secrets function to hide sensitive data
USER_AGENT = os.environ['USER_AGENT']
BOTKEY = os.environ['BOTKEY']

headers = {
  'User-Agent': USER_AGENT,
}

intents = discord.Intents.default()
intents.message_content = True

client = discord.Client(intents=intents)
bot = commands.Bot(command_prefix="!", intents=intents)


async def upload_csv_file(channel, file_path, file_name):
  with open(file_path, "rb") as file:
      data = discord.File(file, filename=file_name)
      response = await channel.send(file=data)
  return response.attachments[0].url

def getStdDeviation(close):
  count = len(close)
  total = 0
  for num in close:
    num = num.replace(',', '')
    total += float(num)
  average = total / count

  variance = 0
  for num in close:
    num = num.replace(',', '')
    variance += (float(num) - average) ** 2
  variance /= (count - 1)
  stdDeviation = math.sqrt(variance)
  return stdDeviation

@client.event
async def on_ready():
  print(f'We have logged in as {client.user}')


@client.event
async def on_message(message):
  # if message.author == client.user:
  #   return
#this commands are just to ease developing
  if message.content.startswith('\\i'):
    await message.channel.send('$income TSLA')
  if message.content.startswith('\\h'):
    await message.channel.send('$history TSLA')
  if message.content.startswith('\\b'):
    await message.channel.send('$balance TSLA')
  if message.content.startswith('\\c'):
    await message.channel.send('$cashflow TSLA')
  if message.content.startswith('\\v'):
    await message.channel.send('$volatility TSLA')
  if message.content.startswith('\\r'):
    await message.channel.send('$revenue TSLA')
# Income statement
  #revenue need to refresh the data from income
  if message.content.startswith('$income') or message.content.startswith('$revenue'):
    if message.content.startswith('$income'):
      stock_ticker = message.content[8:].upper()
    else:
      stock_ticker = message.content[9:].upper()
      
    fin_income = requests.get(
      f'https://finance.yahoo.com/quote/{stock_ticker}/financials?p={stock_ticker}',
      headers=headers)
    incomeSoup = BeautifulSoup(fin_income.text, "html.parser")

    if fin_income.status_code != requests.codes.ok:
      print(fin_income.status_code, fin_income.reason)

    try:
      income_value = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"data-test": "fin-col"})

      income_name = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"class": "D(ib) Va(m) Ell Mt(-3px) W(215px)--mv2 W(200px) undefined"})

      income_year = incomeSoup.find("div", attrs={
        "class": "D(tbhg)"
      }).find("div", attrs={"class": "D(tbr) C($primaryColor)"}).find_all("div")

    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      incomeValues = []
      incomeNames = []
      incomeYears = []
      
      for income_y in income_year:
        # print(income_y.get_text())
        if income_y.get_text() != '':
          incomeYears.append(income_y.get_text())
      # print(incomeYears)
      for income_v in income_value:
        # print(value.get_text())
        incomeValues.append(income_v.get_text())
      # print(incomeValues)
      for income_n in income_name:
        # print(name.get_text())
        incomeNames.append(income_n.get_text())
      # print(incomeNames)

      income_csv = []
      valuesPerCategory = len(incomeYears) - 1
      index = 0
      for n in incomeNames:
        temp = []
        temp.append(n)
        for i in range(valuesPerCategory):
          temp.append(incomeValues[index])
          index += 1
        income_csv.append(temp)

      # Store data as CSV
      # store_data_as_csv(income_csv)
      with open('income_data.csv', 'w', newline='') as file: 
        writer = csv.writer(file)
        writer.writerow(incomeYears)
        writer.writerows(income_csv)
      if message.content.startswith('$income'):
        # Provide a link to download the CSV on Discord
        file_url = await upload_csv_file(message.channel, "income_data.csv", "income_data.csv")
  
        await message.channel.send(f"Scraped data is stored in a CSV file. You can download it from this link:\n{file_url}")

  
#balance sheet
  if message.content.startswith('$balance'):
    stock_ticker = message.content[9:].upper()
    fin_income = requests.get(
      f'https://finance.yahoo.com/quote/{stock_ticker}/balance-sheet?p={stock_ticker}',
      headers=headers)
    incomeSoup = BeautifulSoup(fin_income.text, "html.parser")

    if fin_income.status_code != requests.codes.ok:
      print(fin_income.status_code, fin_income.reason)

    try:
      income_value = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"data-test": "fin-col"})

      income_name = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"class": "D(ib) Va(m) Ell Mt(-3px) W(215px)--mv2 W(200px) undefined"})

      income_year = incomeSoup.find("div", attrs={
        "class": "D(tbhg)"
      }).find("div", attrs={"class": "D(tbr) C($primaryColor)"}).find_all("div")

    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      incomeValues = []
      incomeNames = []
      incomeYears = []
      
      for income_y in income_year:
        # print(income_y.get_text())
        if income_y.get_text() != '':
          incomeYears.append(income_y.get_text())
      # print(incomeYears)
      for income_v in income_value:
        # print(value.get_text())
        incomeValues.append(income_v.get_text())
      # print(incomeValues)
      for income_n in income_name:
        # print(name.get_text())
        incomeNames.append(income_n.get_text())
      # print(incomeNames)

      income_csv = []
      valuesPerCategory = len(incomeYears) - 1
      index = 0
      for n in incomeNames:
        temp = []
        temp.append(n)
        for i in range(valuesPerCategory):
          temp.append(incomeValues[index])
          index += 1
        income_csv.append(temp)

      # Store data as CSV
      # store_data_as_csv(income_csv)
      with open('balance_data.csv', 'w', newline='') as file: 
        writer = csv.writer(file)
        writer.writerow(incomeYears)
        writer.writerows(income_csv)
      # Provide a link to download the CSV on Discord
      file_url = await upload_csv_file(message.channel, "balance_data.csv", "balance_data.csv")

      await message.channel.send(f"Scraped data is stored in a CSV file. You can download it from this link:\n{file_url}")

  
#cash flow
  if message.content.startswith('$cashflow'):
    stock_ticker = message.content[10:].upper()
    fin_income = requests.get(
      f'https://finance.yahoo.com/quote/{stock_ticker}/cash-flow?p={stock_ticker}',
      headers=headers)
    incomeSoup = BeautifulSoup(fin_income.text, "html.parser")

    if fin_income.status_code != requests.codes.ok:
      print(fin_income.status_code, fin_income.reason)

    try:
      income_value = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"data-test": "fin-col"})

      income_name = incomeSoup.find("div", attrs={
        "class": "D(tbrg)"
      }).find_all("div", attrs={"class": "D(ib) Va(m) Ell Mt(-3px) W(215px)--mv2 W(200px) undefined"})

      income_year = incomeSoup.find("div", attrs={
        "class": "D(tbhg)"
      }).find("div", attrs={"class": "D(tbr) C($primaryColor)"}).find_all("div")

    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      incomeValues = []
      incomeNames = []
      incomeYears = []
      
      for income_y in income_year:
        # print(income_y.get_text())
        if income_y.get_text() != '':
          incomeYears.append(income_y.get_text())
      # print(incomeYears)
      for income_v in income_value:
        # print(value.get_text())
        incomeValues.append(income_v.get_text())
      # print(incomeValues)
      for income_n in income_name:
        # print(name.get_text())
        incomeNames.append(income_n.get_text())
      # print(incomeNames)

      income_csv = []
      valuesPerCategory = len(incomeYears) - 1
      index = 0
      for n in incomeNames:
        temp = []
        temp.append(n)
        for i in range(valuesPerCategory):
          temp.append(incomeValues[index])
          index += 1
        income_csv.append(temp)

      # Store data as CSV
      # store_data_as_csv(income_csv)
      with open('cashflow_data.csv', 'w', newline='') as file: 
        writer = csv.writer(file)
        writer.writerow(incomeYears)
        writer.writerows(income_csv)
      # Provide a link to download the CSV on Discord
      file_url = await upload_csv_file(message.channel, "cashflow_data.csv", "cashflow_data.csv")

      await message.channel.send(f"Scraped data is stored in a CSV file. You can download it from this link:\n{file_url}")

  
#historical data
  #here volality is also a condition to run history so we get fresh data to use in volatility
  if message.content.startswith('$history') or message.content.startswith('$volatility'):
    if message.content.startswith('$history'):
      stock_ticker = message.content[9:].upper()
    else:
      stock_ticker = message.content[12:].upper()
    try:
      stock_history = requests.get(f'https://finance.yahoo.com/quote/{stock_ticker}/history?period1=1546300800&period2=1640995200&interval=1mo&filter=history&frequency=1mo&includeAdjustedClose=true', headers=headers)
      history_soup = BeautifulSoup(stock_history.text, "html.parser")
  
      if stock_history.status_code != requests.codes.ok:
        print(stock_history.status_code, stock_history.reason)
  

      history_year = history_soup.find("table", attrs={"data-test": "historical-prices"}).find("tbody").find_all("td", attrs={"class": "Py(10px) Ta(start) Pend(10px)"})

      history_close = history_soup.find("table", attrs={"data-test": "historical-prices"}).find("tbody").find_all("td", attrs={"class": "Py(10px) Pstart(10px)"})

    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      historyYears = []
      historyCloses = []

      for history_y in history_year:
        # print(history_y.get_text())
        historyYears.append(history_y.get_text())
      # print(historyYears)
      for i in range(3, len(history_close), 6):
        # print(history_close[i].get_text())
        historyCloses.append(history_close[i].get_text())
      # print(historyCloses)

      history_csv = []
      index = 0
      for it in range(len(historyYears)):
        temp = []
        temp.append(historyYears[index])
        temp.append(historyCloses[index])
        index += 1
        history_csv.append(temp)
      history_header = ["Date", "Close"]
      # print(history_csv)
      # Store data as CSV
      # store_data_as_csv(history_csv)
      with open('history_data.csv', 'w', newline='') as file: 
        writer = csv.writer(file)
        writer.writerow(history_header)
        writer.writerows(history_csv)
      #won't print if it is call because of volatility
      if message.content.startswith('$history'):
      # Provide a link to download the CSV on Discord
        file_url = await upload_csv_file(message.channel, "history_data.csv", "history_data.csv")

        await message.channel.send(f"Scraped data is stored in a CSV file. You can download it from this link:\n{file_url}")

#volatility
  if message.content.startswith('$volatility'):
    stock_ticker = message.content[12:].upper()
    # await message.channel.send(f'$history {stock_ticker}')
    try:
      dowJones = requests.get('https://finance.yahoo.com/quote/DIA/history?period1=1546300800&period2=1640995200&interval=1mo&filter=history&frequency=1mo&includeAdjustedClose=true', headers=headers)
      
      dJ_soup = BeautifulSoup(dowJones.text, "html.parser")
  
      if dowJones.status_code != requests.codes.ok:
        print(dowJones.status_code, dowJones.reason)
  

      # dJ_year = dJ_soup.find("table", attrs={"data-test": "historical-prices"}).find("tbody").find_all("td", attrs={"class": "Py(10px) Ta(start) Pend(10px)"})

      dJ_close = dJ_soup.find("table", attrs={"data-test": "historical-prices"}).find("tbody").find_all("td", attrs={"class": "Py(10px) Pstart(10px)"})

    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      dJCloses = []

      for i in range(3, len(dJ_close), 6):
        # print(history_close[i].get_text())
        dJCloses.append(dJ_close[i].get_text())

      close_csv = []
      with open("history_data.csv", 'r') as file:
        csvreader = csv.reader(file)
        for row in csvreader:
          if row[1].lower() != 'close':
            close_csv.append(row[1])
      # print(close_csv)
      
      dJ_std = getStdDeviation(dJCloses)
      stock_std = getStdDeviation(close_csv)
      # print(dJ_std)
      # print(stock_std)
      if stock_std > dJ_std:
        await message.channel.send(f'Standard deviation of SPDR Dow Jones Industrial Average ETF Trust (DIA) is {dJ_std:.2f}% while {stock_ticker} is {stock_std:.2f}%. {stock_ticker} is risky')
      else:
        await message.channel.send(f'Standard deviation for SPDR Dow Jones Industrial Average ETF Trust (DIA) is {dJ_std:.2f}% while {stock_ticker} is {stock_std:.2f}%. {stock_ticker} is safe')

  #get revenue
  if message.content.startswith('$revenue'):
    revenue_csv = []
  
    with open("income_data.csv", 'r') as file:
      csvreader = csv.reader(file)
      ctr = 0
      for row in csvreader:
        # print(row)
        if ctr == 2:
          break
        for i in range(len(row)):
          if i >= 2:
            revenue_csv.append(row[i])
        ctr += 1
    amountOfYears = len(revenue_csv) // 2
    # amountOfPercentage = amountOfYears - 1
    revenueYear_csv = revenue_csv[:amountOfYears]
    revenueValue_csv = revenue_csv[amountOfYears:]
    # print(revenueYear_csv)
    # print(revenueValue_csv)
    i = 0
    while i < amountOfYears:
      j = i + 1
      while j < amountOfYears:
        num1 = revenueValue_csv[i].replace(',', '')
        num2 = revenueValue_csv[j].replace(',', '')
        
        num1 = float(num1)
        num2 = float(num2)
        percentage = (num1 / num2 - 1) * 100
        await message.channel.send(f'Percentage of Revenue between {revenueYear_csv[i]} and {revenueYear_csv[j]} is {percentage:.2f}%')
        break
      i += 1

  
#get PE ratio
  if message.content.startswith('$pe_ratio'):
    stock_ticker = message.content[10:].upper()
    try:
      pe = requests.get(f'https://finance.yahoo.com/quote/{stock_ticker}?p={stock_ticker}', headers=headers)
      
      pe_soup = BeautifulSoup(pe.text, "html.parser")
  
      if pe.status_code != requests.codes.ok:
        print(pe.status_code, pe.reason)

      pe_value = float(pe_soup.find("table", attrs={"class": "W(100%) M(0) Bdcl(c)"}).find("td", attrs={"data-test": "PE_RATIO-value"}).text)

      
        
    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      benchmarkPe = 24.2

      if pe_value >= benchmarkPe:
        await message.channel.send(f'{stock_ticker} has good PE ratio of {pe_value:.2f}')
      else:
        await message.channel.send(f'{stock_ticker} has bad PE ratio of {pe_value:.2f}')


  if message.content.startswith('$dividend'):
    stock_ticker = message.content[10:].upper()
    try:
      dividend = requests.get(f'https://finance.yahoo.com/quote/{stock_ticker}?p={stock_ticker}', headers=headers)
      
      dividend_soup = BeautifulSoup(dividend.text, "html.parser")
  
      if dividend.status_code != requests.codes.ok:
        print(dividend.status_code, dividend.reason)

      dividend_value = dividend_soup.find("table", attrs={"class": "W(100%) M(0) Bdcl(c)"}).find("td", attrs={"data-test": "DIVIDEND_AND_YIELD-value", "class": "Ta(end) Fw(600) Lh(14px)"}).text
      print(dividend_value)
    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      if dividend_value == 'N/A (N/A)':
        await message.channel.send('Dividend value is N/A')
      else:
        await message.channel.send(f'Dividend value is {dividend_value}')
  
  #List out all possible commands
  #don't use this command cause it is going to call all functions put descriptions first to use
  if message.content.startswith('$help'):
    await message.channel.send("$income: Get Income Statement\n")
    await message.channel.send("$balance: Get Balance Sheet\n")
    await message.channel.send("$cashflow: Get Cashflow Statement\n")
    await message.channel.send("$volatility: Get stock volatility\n")
    await message.channel.send("$revenue: Get percentage(%) change in revenue\n")
    await message.channel.send("$pe_ratio: Compare stock PE ratio with benchmark\n")

  #display stock financial info
  if message.content.startswith('$stock'):
    stock_ticker = message.content[7:].upper()
    try:
      stock = requests.get(f'https://finance.yahoo.com/quote/{stock_ticker}?p={stock_ticker}', headers=headers)
      
      stock_soup = BeautifulSoup(stock.text, "html.parser")
  
      if stock.status_code != requests.codes.ok:
        print(stock.status_code, stock.reason)

      name = stock_soup.find("h1", attrs={"class": "D(ib) Fz(18px)"}).text
      price = stock_soup.find("fin-streamer", attrs={"class": "Fw(b) Fz(36px) Mb(-4px) D(ib)"}).text
      exchange = stock_soup.find("div", attrs={"id": "mrt-node-Lead-5-QuoteHeader"}).find("div", attrs={"class": "C($tertiaryColor) Fz(12px)"}).text
    
    except:
      await message.channel.send('Invalid Stock Ticker or Server is down')
      
    else:
      await message.channel.send(f"Stock information for {stock_ticker}")
      await message.channel.send(f"Stock's full name: {name}")
      await message.channel.send(f"Stock's price: {price}")
      await message.channel.send(f"Stock's exchange: {exchange}")
      
      
client.run(BOTKEY)

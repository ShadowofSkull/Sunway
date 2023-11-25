// Creating header component to be reused in all pages

class Header extends HTMLElement{    
    connectedCallback(){
        this.innerHTML = `
        <header>
        <div class="header-wrapper">

            <div class="logo">
                <a href="./index.html">
                    <img src="./images/logo-nobg.svg" alt="logo">
                    <h1>Forrest</h1>
                </a>
            </div>

            <label for="hamburger" class="hamburger" onclick="toggleNav()">
                <img src="./images/hamburger.svg" alt="hamburger" id="hamburger">
            </label>

            <nav>
                <a href="./index.html" class="active">Home <span></span></a>
                <a href="./shop.html">Shop <span></span></a>
                <a href="./about.html">About Us <span></span></a>
                <a href="./contact.html">Contact Us <span></span></a>
                <a href="./cart.html">Cart <span></span></a>
                <a href="./login.html" id="nav-login">Login <span></span></a>
            </nav>
        </div>
    </header>
        `
    }
}

window.customElements.define("app-header", Header);
// Initialise selector
const body = document.querySelector("body");
const nav = document.querySelector("nav");
const contactForm = document.getElementById("contact-form");
const login = document.getElementById("login");
const register = document.getElementById("register");
const otp = document.getElementById("otp");
const forgot = document.getElementById("forgot");
const slogan = document.querySelector(".slogan");
const carrot = document.querySelector("#carrot");
const cauliflower = document.querySelector("#cauliflower");
const onion = document.querySelector("#onion");

// when html first loaded
try {
  document.addEventListener("DOMContentLoaded", () => {
    if (window.innerWidth <= 1024) {
      //hide the navigation bar on mobile/tablet at the start
      nav.classList.toggle("hide");
      // remove animation image on mobile/tablet
      carrot.classList.add("hide");
      cauliflower.classList.add("hide");
      onion.classList.add("hide");
    }
  });
} catch (error) {
  console.log(error);
}

// Animation effect for the hero/intro section on index pg
try {
  window.addEventListener("scroll", () => {
    let value = window.scrollY;
    slogan.style.marginLeft = value * -2.0 + "px";
    carrot.style.left = value * -2.5 + "px";
    cauliflower.style.left = value * -4 + "px";
    onion.style.left = value * 3 + "px";
  });
} catch (error) {
  console.log(error);
}

// Toggling the navigation bar on mobile/tablet and stop bg from scrolling
function toggleNav() {
  nav.classList.toggle("hide");
  console.log("toggle");
  body.classList.toggle("disable-scroll");
}

// To display error to user on the page
const setError = (element, message) => {
  const formControl = element.parentElement;
  const errorDisplay = formControl.querySelector(".error");

  errorDisplay.innerText = message;
  formControl.classList.add("error");
  formControl.classList.remove("success");
};

// To display success to user on the page
const setSuccess = (element) => {
  const formControl = element.parentElement;
  const errorDisplay = formControl.querySelector(".error");

  errorDisplay.innerText = "";
  formControl.classList.add("success");
  formControl.classList.remove("error");
};

const setSuccessMsg = (form, msg) => {
  const loginBut = form.querySelector(".submit-but");
  const successDisplay = loginBut.querySelector(".success");

  successDisplay.innerText = msg;
};

const removeMsg = (form) => {
  const loginBut = form.querySelector(".submit-but");
  const successDisplay = loginBut.querySelector(".success");

  successDisplay.innerText = "";
};

// Validation for login
const validateLogin = () => {
  const username = login.querySelector("#username");
  const password = login.querySelector("#password");

  const usernameValue = username.value.trim();
  const passwordValue = password.value.trim();

  if (usernameValue === "") {
    setError(username, "Username is required");
  } else {
    setSuccess(username);
  }

  if (passwordValue === "") {
    setError(password, "Password is required");
  } else {
    setSuccess(password);
  }

  if (usernameValue === "" || passwordValue === "") {
    return false;
  }
  return true;
};

// Validation for contact form
const validateContact = () => {
  const name = contactForm.querySelector("#name");
  const email = contactForm.querySelector("#email");
  const message = contactForm.querySelector("#message");

  const nameValue = name.value.trim();
  const emailValue = email.value.trim();
  const messageValue = message.value.trim();

  if (nameValue === "") {
    setError(name, "Username is required");
  } else {
    setSuccess(name);
  }

  if (emailValue === "") {
    setError(email, "Email is required");
  } else {
    setSuccess(email);
  }

  if (messageValue === "") {
    setError(message, "Message is required");
  } 
  else if (messageValue.length < 10) {
    setError(message, "Message must be at least 10 characters");
  }
  else {
    setSuccess(message);
  }

  if (nameValue === "" || emailValue === "" || messageValue === "" || messageValue.length < 10) {
    return false;
  }
  return true;
};

// Validation for registration
const validateRegister = () => {
  const username = register.querySelector("#username");
  const email = register.querySelector("#email");
  const password = register.querySelector("#password");
  const confirmPassword = register.querySelector("#confirm-password");

  const usernameValue = username.value.trim();
  const emailValue = email.value.trim();
  const passwordValue = password.value.trim();
  const confirmPasswordValue = confirmPassword.value.trim();
  const regx = /^([a-zA-Z0-9\._]+)@([a-zA-Z0-9])+.([a-z]+)(.[a-z]+)?$/;

  if (usernameValue === "") {
    setError(username, "Username is required");
  } else {
    setSuccess(username);
  }

  if (emailValue === "") {
    setError(email, "Email is required");
  } else if (!regx.test(emailValue)) {
    setError(email, "Invalid Email");
  } else {
    setSuccess(email);
  }

  if (passwordValue === "") {
    setError(password, "Password is required");
  } else if (passwordValue.length < 8 || passwordValue.length > 16) {
    console.log(password.length);
    setError(password, "Password length can only be between 8 to 16");
  } else {
    setSuccess(password);
  }

  if (confirmPasswordValue === "") {
    setError(confirmPassword, "Password is required");
  } else if (confirmPasswordValue !== passwordValue) {
    setError(confirmPassword, "Password does not match");
  } else {
    setSuccess(confirmPassword);
  }

  if (
    usernameValue === "" ||
    emailValue === "" ||
    passwordValue === "" ||
    confirmPasswordValue === "" ||
    confirmPasswordValue !== passwordValue ||
    passwordValue.length < 8 ||
    passwordValue.length > 16
  ) {
    return false;
  }
  return true;
};

//
const validateOTP = () => {
  const email = otp.querySelector("#email");
  const password = otp.querySelector("#password");

  const emailValue = email.value.trim();
  const passwordValue = password.value.trim();
  const regx = /^([a-zA-Z0-9\._]+)@([a-zA-Z0-9])+.([a-z]+)(.[a-z]+)?$/;

  if (emailValue === "") {
    setError(email, "Email is required");
  } else if (!regx.test(emailValue)) {
    setError(email, "Invalid Email");
  } else {
    setSuccess(email);
  }

  if (passwordValue === "") {
    setError(password, "OTP is required");
  } else {
    setSuccess(password);
  }

  if (emailValue === "" || passwordValue === "") {
    return false;
  }
  return true;
};

// Forgot password validation
const validatePWReset = () => {
  const password = forgot.querySelector("#password");
  const confirmPassword = forgot.querySelector("#confirm-password");

  const passwordValue = password.value.trim();
  const confirmPasswordValue = confirmPassword.value.trim();

  if (passwordValue === "") {
    setError(password, "Password is required");
  } else if (passwordValue.length < 8 || passwordValue.length > 16) {
    console.log(password.length);
    setError(password, "Password length can only be between 8 to 16");
  } else {
    setSuccess(password);
  }

  if (confirmPasswordValue === "") {
    setError(confirmPassword, "Password is required");
  } else if (confirmPasswordValue !== passwordValue) {
    setError(confirmPassword, "Password does not match");
  } else {
    setSuccess(confirmPassword);
  }

  if (
    confirmPasswordValue === "" ||
    passwordValue === "" ||
    confirmPasswordValue !== passwordValue ||
    passwordValue.length < 8 ||
    passwordValue.length > 16
  ) {
    return false;
  }
  return true;
};

// login validation
try {
  login.addEventListener("submit", (e) => {
    e.preventDefault();

    if (validateLogin()) {
      setSuccessMsg(login, "Login successful!");
    } else {
      removeMsg(register);
    }
  });
} catch (error) {
  console.log(error);
}

// contact form validation
try {
  contactForm.addEventListener("submit", (e) => {
    e.preventDefault();

    if (validateContact()) {
      setSuccessMsg(contactForm, "Message sent!");
    } else {
      removeMsg(register);
    }
  });
} catch (error) {
  console.log(error);
}

// register validation
try {
  register.addEventListener("submit", (e) => {
    e.preventDefault();

    if (validateRegister()) {
      setSuccessMsg(register, "Registration successful!");
    } else {
      removeMsg(register);
    }
  });
} catch (error) {
  console.log(error);
}

// OTP validation
try {
  otp.addEventListener("submit", (e) => {
    e.preventDefault();

    if (validateOTP()) {
      window.location.href = "forgot.html";
    }
  });
} catch (error) {
  console.log(error);
}

// Forgot Password validation
try {
  forgot.addEventListener("submit", (e) => {
    e.preventDefault();

    if (validatePWReset()) {
      setSuccessMsg(forgot, "Password reset successfully!");
    } else {
      removeMsg(register);
    }
  });
} catch (error) {
  console.log(error);
}

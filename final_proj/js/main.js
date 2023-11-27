// Initialise selector
const body = document.querySelector("body");
const nav = document.querySelector("nav");
const contactForm = document.getElementById("contact-form");
const login = document.getElementById("login");
const register = document.getElementById("register");
const slogan = document.querySelector(".slogan");
const carrot = document.querySelector("#carrot");
const cauliflower = document.querySelector("#cauliflower");
const onion = document.querySelector("#onion");

// hide the navigation bar on mobile/tablet at the start
try {
  document.addEventListener("DOMContentLoaded", () => {
    if (window.innerWidth <= 1024) {
      nav.classList.toggle("hide");
      console.log("refresh hide");
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
    carrot.style.left = value * 1.0 + "px";
    cauliflower.style.left = value * 2.5 + "px";
    onion.style.left = value * -1.5 + "px";
  
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
  } else {
    setSuccess(message);
  }
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

  if (usernameValue === "") {
    setError(username, "Username is required");
  } else {
    setSuccess(username);
  }

  if (emailValue === "") {
    setError(email, "Email is required");
  } else {
    setSuccess(email);
  }

  if (passwordValue === "") {
    setError(password, "Password is required");
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
};

// login validation
try {
  login.addEventListener("submit", (e) => {
    e.preventDefault();

    validateLogin();
  });
} catch (error) {
  console.log(error);
}

// contact form validation
try {
  contactForm.addEventListener("submit", (e) => {
    e.preventDefault();

    validateContact();
  });
} catch (error) {
  console.log(error);
}

// register validation
try {
  register.addEventListener("submit", (e) => {
    e.preventDefault();

    validateRegister();
  });
} catch (error) {
  console.log(error);
}

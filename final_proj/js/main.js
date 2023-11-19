// Initialise selector
const nav = document.querySelector("nav");
const contactForm = document.getElementById("contact-form");
const login = document.getElementById("login");
const register = document.getElementById("register");

// hide the navigation bar on mobile/tablet at the start
if (screen.width <= 1024) {
  nav.classList.toggle("hide");
}

// Toggling the navigation bar on mobile/tablet
function toggleNav() {
  nav.classList.toggle("hide");
  console.log("clicked");
}

const setError = (element, message) => {
  const formControl = element.parentElement;
  const errorDisplay = formControl.querySelector(".error");

  errorDisplay.innerText = message;
  formControl.classList.add("error");
  formControl.classList.remove("success");
};

const setSuccess = (element) => {
  const formControl = element.parentElement;
  const errorDisplay = formControl.querySelector(".error");

  errorDisplay.innerText = "";
  formControl.classList.add("success");
  formControl.classList.remove("error");
};

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

try {
  // login validation
  login.addEventListener("submit", (e) => {
    e.preventDefault();

    validateLogin();
  });
} catch (error) {
  console.log(error);
}

try {
  // contact form validation
  contactForm.addEventListener("submit", (e) => {
    e.preventDefault();

    validateContact();
  });
} catch (error) {
  console.log(error);
}

try {
  // register validation
  register.addEventListener("submit", (e) => {
    e.preventDefault();

    validateRegister();
  });
} catch (error) {
  console.log(error);
}

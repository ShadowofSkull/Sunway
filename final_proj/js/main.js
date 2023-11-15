// Initialise selector
const nav = document.querySelector("nav");
const contactForm = document.getElementById("contact-form");

// form validation
contactForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const name = document.getElementById("name")
    const email = document.getElementById("email")
    const message = document.getElementById("message")

    if (name.value === "") {
        console.log("Name can't be empty")
    }
    
    if (email.value === "") {
        console.log("Email can't be empty")
    }

    
    if (message.value === "") {
        console.log("Email can't be empty")
    }

})

function toggleNav() {
    nav.classList.toggle("hide");
    console.log("clicked");
}
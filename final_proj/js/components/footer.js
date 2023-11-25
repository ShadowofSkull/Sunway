class Footer extends HTMLElement{    
    connectedCallback(){
        this.innerHTML = `
    <footer>
        <div class="col">
            <span class="brand"><img src="./images/logo-nobg.svg" alt="">Forrest</span>
            <div class="contact">
                
                <h4>Contact</h4>
                <p>Address: 5, Jalan Universiti, Bandar Sunway, 47500 Petaling Jaya, Selangor
                    <br>Phone: 123456789
                    <br>Email: 23032998@imail.sunway.edu.my
                </p>
            </div>
            <div class="follow">

                <h5>Follow us</h5>
                <div class="social">
                    <a href="https://www.facebook.com/"><img src="./images/svg/facebook.svg" alt="facebook"></a>
                    <a href="https://www.instagram.com/"><img src="./images/svg/instagram.svg" alt="instagram"></a>
                    <a href="https://www.twitter.com/"><img src="./images/svg/twitter.svg" alt="twitter"></a>
                    <a href="https://www.youtube.com/"><img src="./images/svg/youtube.svg" alt="youtube"></a>
    
                </div>
            </div>
        </div>
        <div class="col">
            <div class="footer-nav">
                <h4>Navigation</h4>
                <a href="./index.html">Home</a>
                <a href="./shop.html">Shop</a>
                <a href="./about.html">About Us</a>
                <a href="./contact.html">Contact Us</a>
                <a href="./cart.html">Cart</a>
                <a href="./login.html">Login</a>
            </div>
        </div>
        <div class="col">
            <div class="payment">
                <h4>Secure payment gateway</h4>
                <div class="gateway">
                    <img src="./images/svg/visa.svg" alt="visa">
                    <img src="./images/svg/mastercard.svg" alt="mastercard">
                </div>
            </div>
            <div class="version">
                
                <p>Version 1.0.0 <br>
                    Last modified: 20/10/2023 <br>
                    &copy 2024, Forrest.co
                </p>
            </div>
        </div>
        
    </footer>
        `
    }
}

window.customElements.define("app-footer", Footer);

// Sample
// const template = document.createElement('template');
// template.innerHTML = `
//     <div></div> 
// `;

// class Sample extends HTMLElement{
//     constructor(){
//         super();
//         this.attachShadow({mode: 'open'});
//         this.shadowRoot.appendChild(template.content.cloneNode(true));
//         this.shadowRoot.querySelector('h3').innerText = this.getAttribute('name')
//     }
// }

// window.customElements.define("app-sample", Sample);

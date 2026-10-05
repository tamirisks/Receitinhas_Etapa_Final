const login = document.getElementById("login");
const senha = document.getElementById("senha");

const limpar = document.querySelector(".botao-limpar a");
const confirmar = document.querySelector(".botao-confirmar a");


limpar.addEventListener("click", function(event) {
    event.preventDefault();

    login.value = "";
    senha.value = "";
});


confirmar.addEventListener("click", function(event) {

    if (login.value === "" || senha.value === "") {
        event.preventDefault();

        alert("Preencha o login e a senha!");
    } else {
        alert("Login realizado!");
    }

});
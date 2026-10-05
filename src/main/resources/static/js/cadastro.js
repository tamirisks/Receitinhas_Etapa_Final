const confirmar = document.querySelector(".botao-confirmar a");

confirmar.addEventListener("click", function(event) {

    const nome = document.getElementById("nome").value;
    const senha = document.getElementById("senha").value;
    const email = document.getElementById("email").value;
    const contato = document.getElementById("contato").value;

    if (nome === "" || senha === "" || email === "" || contato === "") {
        event.preventDefault();

        alert("Preencha todos os campos!");
    } else {
        alert("Cadastro realizado!");
    }

});
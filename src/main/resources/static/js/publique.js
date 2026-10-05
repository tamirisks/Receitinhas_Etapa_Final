const cadastrar = document.querySelector(".botao-cadastrar a");

cadastrar.addEventListener("click", function(event) {

    const nome = document.getElementById("nome-receita").value;
    const rendimento = document.getElementById("rendimento").value;
    const tempo = document.getElementById("tempo").value;
    const nivel = document.getElementById("nivel").value;
    const ingredientes = document.getElementById("ingredientes").value;
    const preparo = document.getElementById("preparo").value;
    const comentario = document.getElementById("comentario").value;

    if (
        nome === "" ||
        rendimento === "" ||
        tempo === "" ||
        nivel === "" ||
        ingredientes === "" ||
        preparo === "" ||
        comentario === ""
    ) {

        event.preventDefault();

        alert("Preencha todos os campos!");

    } else {

        alert("Receita cadastrada com sucesso!");

    }

});
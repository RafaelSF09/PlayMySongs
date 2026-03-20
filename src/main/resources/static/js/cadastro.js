function carregarStyles(){
    const generos = document.getElementById("stylesCombobox");
        fetch("http://localhost:8080/apis/get-music-styles")
            .then(response => {
                if(response.status === 200){
                    return response.json()
                        .then(json=>{
                            generos.innerHTML += carregarCombobox(json);
                        });
                }else{
                    alert("Não há resultados");
                }
            })
            .catch(erro => generos.innerHTML = "erro");
}

function carregarCombobox(json){
    let options = "";
    for(estilo of json){
        options += `<option value="${estilo.nome}">${estilo.nome}</option>`
    }
    return options;
}

function cadastrarMusica() {
    const formMusica = document.forms[0];
    const requestOptions = {
        method: "POST",
        body: new FormData(formMusica)
    };
    fetch("http://localhost:8080/apis/music-upload", requestOptions)
        .then((response) => {
            if (response.status === 200){
                return response.json()
                    .then(musica =>{
                        alert(musica.artist + ' adicionado com sucesso');
                    });
            }else{
                alert("Erro ao adicionar a musica!");
            }
        });
}
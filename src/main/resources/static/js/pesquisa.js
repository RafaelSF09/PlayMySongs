function pesquisarMusicaNome() {
    const musicList = document.getElementById("musicList");
    const pesquisa = document.getElementById("searchInput");

    fetch("http://localhost:8080/apis/find-musics?keyword=" + pesquisa.value)
        .then(response => {
            if (response.status === 200) {
                return response.json().then(json => {
                    musicList.innerHTML = montarLista(json);
                });
            } else {
                musicList.innerHTML = "Não há resultados";
            }
        })
        .catch(() => musicList.innerHTML = "Erro");
}
function montarLista(json) {
    let conteudo = "";
    for (let musica of json) {
        conteudo += `
        <div class="music-item">
            <div>
               <h4>${musica.title}</h4>
               <p>-</p>
               <p>${musica.artist}</p>
            </div>
            <audio controls>
                <source src="../uploads/${musica.musicFile}.mp3" type="audio/mpeg">
            </audio>
        </div>`;
    }

    return conteudo;
}

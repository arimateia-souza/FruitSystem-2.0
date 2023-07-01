function Formulario(){
    return(
        <form>
            <label for="nomeFruta">Nome: </label>
            <input type="text" placeholder="nome" id="nomeFruta"/>

            <label for="nome">descrição:</label>
            <input type="text" placeholder="descrição" id="descrição"/>

            <label for="nome">preco:</label>
            <input type="number" placeholder="preco" id="preco"/>

            <label form="nome">categoria: </label>
            <select id="categoria" >
                <option value="">Selecione</option>
                <option value="cítricas">cítricas</option>
                <option value="tropicais">tropicais</option>
                <option value="vermelha">vermelha</option>
                <option value="exóticas">exóticas</option>
            </select>
            <button type="submit">Cadastrar</button>
        </form>

    )
}

export default Formulario;
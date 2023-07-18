import {useState} from "react";

function CreateModal(){
    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState(0)
    const [descricao, setDescricao] = useState(0)

    return(
        <div>
            <div>
                <h2>Cadastrar fruta</h2>
            </div>
            <form>
                <label>nome: </label>
                <input value={nome}/>

                <label>preco: </label>
                <input value={preco}/>

                <label>descricao: </label>
                <input value={descricao}/>

            </form>

        </div>
    )
}
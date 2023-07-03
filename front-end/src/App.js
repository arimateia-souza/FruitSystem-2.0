
import './App.css';
import Formulario from "./components/Formulario";
import Tabela from "./components/Tabela";
import {useEffect, useState} from "react";

function App() {
    const [produtos, setProdutos] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/fruta")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setProdutos(retorno_convertido))

    }, []);

    //<p>{JSON.stringify(produtos)}</p>
  return (
    <div>

        <Formulario/>
        <Tabela frutas={produtos}/>
    </div>
  );
}

export default App;

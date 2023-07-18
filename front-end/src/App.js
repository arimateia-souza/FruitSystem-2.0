
import './App.css';
import Formulario from "./components/Formulario";
import Tabela from "./components/Tabela";
import {useEffect, useState} from "react";
import Navbar from "./components/navbar";

function App() {


    const [produtos, setProdutos] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/fruta")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setProdutos(retorno_convertido))

    }, []);



  return (
    <div>
        <Navbar/>

        <Tabela frutas={produtos}/>
        <Formulario/>

    </div>
  );
}

export default App;

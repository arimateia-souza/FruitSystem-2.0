
import './App.css';
import Formulario from "./components/Formulario";
import Tabela from "./components/Tabela";
import {useEffect, useState} from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";


function App() {
    const produto = {
        nome: '',
        descricao: '',
        preco: 0
    }


    const [frutas, setFrutas] = useState([]);
    const [objProduto, setObjtProduto] = useState(produto);

//get para listar
    useEffect(()=>{
        fetch("http://localhost:8080/fruta")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setFrutas(retorno_convertido))

    }, []);




    return (
        <div>
            <Header/>
            <p>{JSON.stringify(objProduto)}</p>
            <Formulario />

            <Tabela frutas={frutas}/>
            <Footer/>

        </div>
    );
}

export default App;
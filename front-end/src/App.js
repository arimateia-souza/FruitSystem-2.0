
import './App.css';
import Formulario from "./components/Formulario";
import Tabela from "./components/Tabela";
import {useEffect, useState} from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";


function App() {


    const [produtos, setProdutos] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/fruta")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setProdutos(retorno_convertido))

    }, []);



    return (
        <div>
            <Header/>
            <Formulario/>
            <Tabela frutas={produtos}/>
            <Footer/>

        </div>
    );
}

export default App;
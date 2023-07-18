
import './App.css';
import Formulario from "./components/Formulario";
import Tabela from "./components/Tabela";
import {useEffect, useState} from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";


function App() {

    const fruta = {
        nome: '',
        descricao: '',
        preco: 0,
        categoria: ''
    }

    const [frutas, setFrutas] = useState([]);
    const [objFruta, setObjFruta] = useState(fruta)

    useEffect(()=>{
        fetch("http://localhost:8080/fruta")
            .then(retorno => retorno.json())
            .then(retorno_convertido => setFrutas(retorno_convertido))

    }, []);
    const digito = (e) => {
        setObjFruta({ ...objFruta, [e.target.name]: e.target.value });
    };


    const cadastrar = () => {
        fetch("http://localhost:8080/fruta",{
           method:'post',
            body:JSON.stringify(objFruta),
            headers:{
               'Content-type':'application/jason',
                'Accept':'application/json'
            }

        })

    }



    return (
        <div>
            <Header/>
            <Formulario eventoTeclado={digito} />

            <Tabela frutas={frutas}/>
            <Footer/>

        </div>
    );
}

export default App;
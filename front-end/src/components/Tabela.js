
import React from "react";


function Tabela({ frutas }) {
    return (
        <div className="container px-4 px-lg-5 mt-5">
            <h1>Listar frutas do banco</h1>
            <table className="table table-striped auto">
                <thead>
                <tr>
                    <th scope="col" className="text-center">Nome</th>
                    <th scope="col" className="text-center">Preço</th>
                    <th scope="col" className="text-center">Categoria</th>
                    <th scope="col" className="text-center">Ação</th>
                </tr>
                </thead>
                <tbody>
                {frutas.map((obj) => (
                    <tr >
                        <td className="text-center" scope="row">{obj.nome}</td>
                        <td className="text-center">R$ {obj.preco}</td>
                        <td className="text-center">{obj.categoria}</td>
                        <td className="text-center">
                            <button className="btn btn-success btn-space">Selecionar</button>
                            <button className="btn btn-danger btn-space">Deletar</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Tabela;
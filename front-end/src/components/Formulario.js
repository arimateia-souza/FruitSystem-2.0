

export default function Formulario() {

    return (
        <div className="container px-4 px-lg-5 mt-5">
            <form>
                <h1>Cadastrar fruta</h1>
                <div className="mb-3">
                    <label className="form-label" htmlFor="nomeFruta">Nome:</label>
                    <input className="form-control" type="text" placeholder="Digite o nome da fruta" id="nome" />
                </div>
                <div className="form-group">
                    <label htmlFor="exampleFormControlTextarea1">Descrição:</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" placeholder="Digite uma breve descrição do produto"></textarea>
                </div>

                <div className="d-flex">
                    <div className="col-6 my-2 mx-0">
                        <label htmlFor="preco">Preço:</label>
                        <input  className="form-control mr-sm-2" type="number" placeholder="Informe o valor do produto" id="preco" />
                    </div>

                    <div className="col-6 my-2 mx-1">
                        <label className="mr-sm-2" htmlFor="inlineFormCustomSelect">Categoria:</label>
                        <div className="input-group">
                            <select className="form-control custom-select mr-sm-2" id="inlineFormCustomSelect">
                                <option selected>Selecione uma categoria...</option>
                                <option value="cítricas">Cítricas</option>
                                <option value="tropicais">Tropicais</option>
                                <option value="vermelha">Vermelha</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div className="d-flex justify-content-end">
                    <button className="btn btn-primary text-right" type="submit">Cadastrar</button>
                </div>
            </form>
        </div>
    );
}


<<<<<<< Updated upstream
import Grafico from "../../components/dadosUsina/grafico";
import Menu from "../../components/menu/index";
import "./style.css";

=======
import Grafico1 from "../../components/dadosAgua/index";
import Menu from "../../components/menu/index";
import RelatorioAgua from "../../components/relatorioAgua/index";
import "./style.css";
>>>>>>> Stashed changes

function Dashboard() {
  return (
    <div>
<<<<<<< Updated upstream
      <div className="container">
        <div className="content">
          <Menu />
        </div>
        <div className="section">
          <h1>Dashboard</h1>
          <Grafico />
        </div>
      </div>
=======
    <div className="container">
      <div className="content">
        <Menu />
      </div>
      <div className="section">
        <h1 className ="Titulo" >Grafico Água</h1>
        <Grafico1 />
        <h1 className ="Titulo" >Relatorio Água</h1>
        <RelatorioAgua />
      </div>
      
>>>>>>> Stashed changes
    </div>
  </div>
);
}

export default Dashboard;


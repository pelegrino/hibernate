package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.DaoGeneric;
import model.UsuarioPessoa;

@ManagedBean(name="usuarioPessoaManagedBean")
@ViewScoped
public class UsuarioPessoaManagedBean {

	
	private UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
	private DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
	private List<UsuarioPessoa> list = new ArrayList<UsuarioPessoa>();
	
	

	//Getters e Setters
	
	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}
	
	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}
	
	public List<UsuarioPessoa> getList() {
		list = daoGeneric.listar(UsuarioPessoa.class);
		return list;
	}
	
	
	
	//Metodos
	
	public String salvar() {
		daoGeneric.salvar(usuarioPessoa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação", "Salvo com sucesso"));
		return "";
	}
	
	public String novo() {
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}
	
	public String remover() {
		daoGeneric.deletarPorId(usuarioPessoa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação", "Removido com sucesso"));
		usuarioPessoa = new UsuarioPessoa();
		return "";
	}
	
}

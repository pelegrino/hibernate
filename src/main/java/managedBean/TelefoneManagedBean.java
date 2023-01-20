package managedBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.DaoTelefones;
import dao.DaoUsuario;
import model.TelefoneUser;
import model.UsuarioPessoa;

@ManagedBean(name = "telefoneManagedBean")
@ViewScoped
public class TelefoneManagedBean {
	
	
	public UsuarioPessoa user = new UsuarioPessoa();
	private DaoUsuario<UsuarioPessoa> daoUser = new DaoUsuario<UsuarioPessoa>();
	private DaoTelefones<TelefoneUser> daoTelefones = new DaoTelefones<TelefoneUser>();
	private TelefoneUser telefone = new TelefoneUser();
	

	@PostConstruct
	public void init() {
		
		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		user = daoUser.pesquisar(Long.parseLong(coduser), UsuarioPessoa.class);
	}
	
	public String salvar() {
		telefone.setUsuarioPessoa(user);
		daoTelefones.salvar(telefone);
		telefone = new TelefoneUser();
		user = daoUser.pesquisar(user.getId(), UsuarioPessoa.class);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação", "Salvo com sucesso"));
		return "";
	}
	
	public String removeTelefone() throws Exception {
		daoTelefones.deletarPorId(telefone);
		user = daoUser.pesquisar(user.getId(), UsuarioPessoa.class);
		telefone = new TelefoneUser();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação", "Telefone removido"));
		
		return "";
	}
	
	
	public UsuarioPessoa getUser() {
		return user;
	}
	
	public void setUser(UsuarioPessoa user) {
		this.user = user;
	}
	
	public DaoTelefones<TelefoneUser> getDaoTelefones() {
		return daoTelefones;
	}
	
	public void setDaoTelefones(DaoTelefones<TelefoneUser> daoTelefones) {
		this.daoTelefones = daoTelefones;
	}
	
	public void setTelefone(TelefoneUser telefone) {
		this.telefone = telefone;
	}
	
	public TelefoneUser getTelefone() {
		return telefone;
	}
	
}

package bibliotech.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bibliotech")


public class Model {
	
	@Column(nullable = false )
	private String Autor;
	
	@Column(nullable = false )
	private String titulo;
	
	@Column(nullable = false )
	private String nome;
	
	@Column(nullable = false )
	private int quantidade;
	
	@Column(nullable = false )
	private long id ;
	
	@Column(name = "imag_url")
    private String imagURL; // URL da imagem
}

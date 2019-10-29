
class ClienteDtotester extends ClienteDto{


        /**
     * Constructor para propositos de testeo
     * 
     * 
     * @param id,nombre,direccion,ciudad,estado,pais,codpos,tel,corel,termpago,
     * paltrac,paled,palproo,horatra,horaed,horaproo
     */
    
    
    public ClienteDtotester(Long id, String nombre, String direccion,
    		String ciudad, String estado, String pais, String codpos,
    		String tel, String corel, int termpago, Double paltrac,
    		Double paled, Double palproo, Double horatra, Double horaed, Double horaproo) {
    	
        this.idCliente = id;
        this.nombreCliente = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codpos;
        this.telefono = tel;
        this.correoElectronico = corel;
        this.terminoPago = termpago;
        this.palabraTraduccion = paltrac;
        this.palabraEdicion = paled;
        this.palabraProofreading = palproo;
        this.horaTraduccion = horatra;
        this.horaEdicion = horaed;
        this.horaProofreading = horaproo;
    }

    
    
}
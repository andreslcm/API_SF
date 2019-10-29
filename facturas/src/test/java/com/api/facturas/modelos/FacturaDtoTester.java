class FacturaDtoTester extends DtoFactura{

        /**
     * Constructor para propositos de testeo
     * 
     * 
     * @param id,numfac, orden, fechafac, fechaven, sobtot, imp, total, notas,
     *  pagada
     */
    
    public FacturaDtoTester(Long id, Long numfac, String orden, Date fechafac,
    		Date fechaven, Double subtot, Double imp, Double total,
    		String notas, boolean pagada) {
        this.numeroFactura = numfac;
        this.ordenCompra = orden;
        this.fechaFactura = fechafac;
        this.fechaVencimiento = fechaven;
        this.subtotal = subtot;
        this.impuestos = imp;
        this.total = total;
        this.notas = notas;
        this.estaPagada = pagada;
        this.idFactura = id;
    	
    }




}
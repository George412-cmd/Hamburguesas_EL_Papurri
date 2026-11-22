package com.prueba1.api1.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Hamburguesas y sus precios

    @Column(nullable = false)
    private String hamburguesaSencilla;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaSencilla = BigDecimal.valueOf(60.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaSencillaCombo = BigDecimal.valueOf(90.00);

    @Column(nullable = false)
    private String hamburguesaHawaiana;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaHawaiana = BigDecimal.valueOf(60.00);
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaHawaianaCombo = BigDecimal.valueOf(90.00);

    @Column(nullable = false)
    private String hamburguesaFit;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaFit = BigDecimal.valueOf(95.00);
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaFitCombo = BigDecimal.valueOf(120.00);

    @Column(nullable = false)
    private String hamburguesaPerrona;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaPerrona = BigDecimal.valueOf(110.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaPerronaCombo = BigDecimal.valueOf(140.00);

    @Column(nullable = false)
    private String hamburguesaDoble;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaDoble = BigDecimal.valueOf(95.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaDobleCombo = BigDecimal.valueOf(120.00);

    @Column(nullable = false)
    private String hamburguesaRanchera;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaRanchera = BigDecimal.valueOf(115.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaRancheraCombo = BigDecimal.valueOf(145.00);

    @Column(nullable = false)
    private String hamburguesaDePollo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaDePollo = BigDecimal.valueOf(100.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHamburguesaDePolloCombo = BigDecimal.valueOf(130.00);

    //Bebidas y sus precios
    
    @Column(nullable = false)
    private String aguaJamaica;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioAguaJamaicaMedioLitro = BigDecimal.valueOf(25.00);
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioAguaJamaicaLitro = BigDecimal.valueOf(40.00);

    @Column(nullable = false)
    private String aguaLimon;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioAguaLimonMedioLitro = BigDecimal.valueOf(20.00);

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioAguaLimonLitro = BigDecimal.valueOf(40.00);


    //Papas y sus precios

     @Column(nullable = false)
    private String papasOrden;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPapasOrden = BigDecimal.valueOf(150.00);

     @Column(nullable = false)
    private String papasEspeciales;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPapasEspeciales = BigDecimal.valueOf(150.00);

     @Column(nullable = false)
    private String papasSuperEspeciales;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPapasSuperEspeciales = BigDecimal.valueOf(150.00);


    //Papurris y sus precios
    @Column(nullable = false)
    private String papurrisSencilla;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPapurrisSencilla = BigDecimal.valueOf(150.00);

    @Column(nullable = false)
    private String papurrisBorracha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPapurrisBorracha = BigDecimal.valueOf(150.00);

    // Relación con DetallePedido

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles = new ArrayList<>();

    protected Productos() {}


    // Agrega getters y setters (id)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    //Getters y setters para las hamburguesas

    public String getHamburguesaSencilla() {
        return hamburguesaSencilla;
    }
    public void setHamburguesaSencilla(String hamburguesaSencilla) {
        this.hamburguesaSencilla = hamburguesaSencilla;
    }
    public BigDecimal getPrecioHamburguesaSencilla() {
        return precioHamburguesaSencilla;
    }
    public void setPrecioHamburguesaSencilla(BigDecimal precioHamburguesaSencilla) {
        this.precioHamburguesaSencilla = precioHamburguesaSencilla;
    }
    public BigDecimal getPrecioHamburguesaSencillaCombo() {
        return precioHamburguesaSencillaCombo;
    }
    public void setPrecioHamburguesaSencillaCombo(BigDecimal precioHamburguesaSencillaCombo) {
        this.precioHamburguesaSencillaCombo = precioHamburguesaSencillaCombo;
    }

    public String getHamburguesaFit() {
        return hamburguesaFit;
    }
    public void setHamburguesaFit(String hamburguesaFit) {
        this.hamburguesaFit = hamburguesaFit;
    }
    public BigDecimal getPrecioHamburguesaFit() {
        return precioHamburguesaFit;
    }
    public void setPrecioHamburguesaFit(BigDecimal precioHamburguesaFit) {
        this.precioHamburguesaFit = precioHamburguesaFit;
    }
    public BigDecimal getPrecioHamburguesaFitCombo() {
        return precioHamburguesaFitCombo;
    }
    public void setPrecioHamburguesaFitCombo(BigDecimal precioHamburguesaFitCombo) {
        this.precioHamburguesaFitCombo = precioHamburguesaFitCombo;
    }

    public String getHamburguesaHawaiana() {
        return hamburguesaHawaiana;
    }
    public void setHamburguesaHawaiana(String hamburguesaHawaiana) {
        this.hamburguesaHawaiana = hamburguesaHawaiana;
    }
    public BigDecimal getPrecioHamburguesaHawaiana() {
        return precioHamburguesaHawaiana;
    }
    public void setPrecioHamburguesaHawaiana(BigDecimal precioHamburguesaHawaiana) {
        this.precioHamburguesaHawaiana = precioHamburguesaHawaiana;
    }
    public BigDecimal getPrecioHamburguesaHawaianaCombo() {
        return precioHamburguesaHawaianaCombo;
    }
    public void setPrecioHamburguesaHawaianaCombo(BigDecimal precioHamburguesaHawaianaCombo) {
        this.precioHamburguesaHawaianaCombo = precioHamburguesaHawaianaCombo;
    }

    public String getHamburguesaPerrona() {
        return hamburguesaPerrona;
    }
    public void setHamburguesaPerrona(String hamburguesaPerrona) {
        this.hamburguesaPerrona = hamburguesaPerrona;
    }
    public BigDecimal getPrecioHamburguesaPerrona() {
        return precioHamburguesaPerrona;
    }
    public void setPrecioHamburguesaPerrona(BigDecimal precioHamburguesaPerrona) {
        this.precioHamburguesaPerrona = precioHamburguesaPerrona;
    }
    public BigDecimal getPrecioHamburguesaPerronaCombo() {
        return precioHamburguesaPerronaCombo;
    }
    public void setPrecioHamburguesaPerronaCombo(BigDecimal precioHamburguesaPerronaCombo) {
        this.precioHamburguesaPerronaCombo = precioHamburguesaPerronaCombo;
    }
    
    public String getHamburguesaDoble() {
        return hamburguesaDoble;
    }
    public void setHamburguesaDoble(String hamburguesaDoble) {
        this.hamburguesaDoble = hamburguesaDoble;
    }
    public BigDecimal getPrecioHamburguesaDoble() {
        return precioHamburguesaDoble;
    }
    public void setPrecioHamburguesaDoble(BigDecimal precioHamburguesaDoble) {
        this.precioHamburguesaDoble = precioHamburguesaDoble;
    }
    public BigDecimal getPrecioHamburguesaDobleCombo() {
        return precioHamburguesaDobleCombo;
    }
    public void setPrecioHamburguesaDobleCombo(BigDecimal precioHamburguesaDobleCombo) {
        this.precioHamburguesaDobleCombo = precioHamburguesaDobleCombo;
    }
    public String getHamburguesaRanchera() {
        return hamburguesaRanchera;
    }
    public void setHamburguesaRanchera(String hamburguesaRanchera) {
        this.hamburguesaRanchera = hamburguesaRanchera;
    }
    public BigDecimal getPrecioHamburguesaRanchera() {
        return precioHamburguesaRanchera;
    }
    public void setPrecioHamburguesaRanchera(BigDecimal precioHamburguesaRanchera) {
        this.precioHamburguesaRanchera = precioHamburguesaRanchera;
    }
    public BigDecimal getPrecioHamburguesaRancheraCombo() {
        return precioHamburguesaRancheraCombo;
    }
    public void setPrecioHamburguesaRancheraCombo(BigDecimal precioHamburguesaRancheraCombo) {
        this.precioHamburguesaRancheraCombo = precioHamburguesaRancheraCombo;
    }

    public String getHamburguesaDePollo() {
        return hamburguesaDePollo;
    }
    public void setHamburguesaDePollo(String hamburguesaDePollo) {
        this.hamburguesaDePollo = hamburguesaDePollo;
    }
    public BigDecimal getPrecioHamburguesaDePollo() {
        return precioHamburguesaDePollo;
    }
    public void setPrecioHamburguesaDePollo(BigDecimal precioHamburguesaDePollo) {
        this.precioHamburguesaDePollo = precioHamburguesaDePollo;
    }
    public BigDecimal getPrecioHamburguesaDePolloCombo() {
        return precioHamburguesaDePolloCombo;
    }
    public void setPrecioHamburguesaDePolloCombo(BigDecimal precioHamburguesaDePolloCombo) {
        this.precioHamburguesaDePolloCombo = precioHamburguesaDePolloCombo;
    }



    //Getters y setters para las bebidas

    public String getAguaLimon() {
        return aguaLimon;
    }
    public void setAguaLimon(String aguaLimon) {
        this.aguaLimon = aguaLimon;
    }
    public BigDecimal getPrecioAguaLimonMedioLitro() {
        return precioAguaLimonMedioLitro;
    }
    public void setPrecioAguaLimonMedioLitro(BigDecimal precioAguaLimonMedioLitro) {
        this.precioAguaLimonMedioLitro = precioAguaLimonMedioLitro;
    }
    public BigDecimal getPrecioAguaLimonLitro() {
        return precioAguaLimonLitro;
    }
    public void setPrecioAguaLimonLitro(BigDecimal precioAguaLimonLitro) {
        this.precioAguaLimonLitro = precioAguaLimonLitro;
    }

    public String getAguaJamaica() {
        return aguaJamaica;
    }
    public void setAguaJamaica(String aguaJamaica) {
        this.aguaJamaica = aguaJamaica;
    }
    public BigDecimal getPrecioAguaJamaicaMedioLitro() {
        return precioAguaJamaicaMedioLitro;
    }
    public void setPrecioAguaJamaicaMedioLitro(BigDecimal precioAguaJamaicaMedioLitro) {
        this.precioAguaJamaicaMedioLitro = precioAguaJamaicaMedioLitro;
    }
    public BigDecimal getPrecioAguaJamaicaLitro() {
        return precioAguaJamaicaLitro;
    }
    public void setPrecioAguaJamaicaLitro(BigDecimal precioAguaJamaicaLitro) {
        this.precioAguaJamaicaLitro = precioAguaJamaicaLitro;
    }


    //Getters y setters para las papas
    public String getPapasOrden() {
        return papasOrden;
    }
    public void setPapasOrden(String papasOrden) {
        this.papasOrden = papasOrden;
    }
    public BigDecimal getPrecioPapasOrden() {
        return precioPapasOrden;
    }
    public void setPrecioPapasOrden(BigDecimal precioPapasOrden) {
        this.precioPapasOrden = precioPapasOrden;
    }

    public String getPapasEspeciales() {
        return papasEspeciales;
    }
    public void setPapasEspeciales(String papasEspeciales) {
        this.papasEspeciales = papasEspeciales;
    }
    public BigDecimal getPrecioPapasEspeciales() {
        return precioPapasEspeciales;
    }
    public void setPrecioPapasEspeciales(BigDecimal precioPapasEspeciales) {
        this.precioPapasEspeciales = precioPapasEspeciales;
    }

    public String getPapasSuperEspeciales() {
        return papasSuperEspeciales;
    }
    public void setPapasSuperEspeciales(String papasSuperEspeciales) {
        this.papasSuperEspeciales = papasSuperEspeciales;
    }
    public BigDecimal getPrecioPapasSuperEspeciales() {
        return precioPapasSuperEspeciales;
    }
    public void setPrecioPapasSuperEspeciales(BigDecimal precioPapasSuperEspeciales) {
        this.precioPapasSuperEspeciales = precioPapasSuperEspeciales;
    }



    //Getters y setters para las papurris
    public String getPapurrisSencilla() {
        return papurrisSencilla;
    }
    public void setPapurrisSencilla(String papurrisSencilla) {
        this.papurrisSencilla = papurrisSencilla;
    }
    public BigDecimal getPrecioPapurrisSencilla() {
        return precioPapurrisSencilla;
    }
    public void setPrecioPapurrisSencilla(BigDecimal precioPapurrisSencilla) {
        this.precioPapurrisSencilla = precioPapurrisSencilla;
    }

    public String getPapurrisBorracha() {
        return papurrisBorracha;
    }
    public void setPapurrisBorracha(String papurrisBorracha) {
        this.papurrisBorracha = papurrisBorracha;
    }
    public BigDecimal getPrecioPapurrisBorracha() {
        return precioPapurrisBorracha;
    }
    public void setPrecioPapurrisBorracha(BigDecimal precioPapurrisBorracha) {
        this.precioPapurrisBorracha = precioPapurrisBorracha;
    }
}

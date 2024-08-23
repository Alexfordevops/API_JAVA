package App.Java.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name="TB_PRODUCTS")
public class ProductModel implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID productId;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;
    private String productName;
    private String productOrigin;
    private double productPrice;
    private int productQuantity;

    public UUID getProductId() {
        return productId;
    }
    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductOrigin() {
        return productOrigin;
    }
    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

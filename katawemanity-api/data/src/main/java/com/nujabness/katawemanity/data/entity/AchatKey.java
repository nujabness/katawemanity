package com.nujabness.katawemanity.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AchatKey implements Serializable {

    @Column(name = "id_cli")
    private Integer id_cli;

    @Column(name = "id_prod")
    private Integer id_prod;



    public Integer getId_cli() {
        return id_cli;
    }

    public void setId_cli(Integer id_cli) {
        this.id_cli = id_cli;
    }

    public Integer getId_prod() {
        return id_prod;
    }

    public void setId_prod(Integer id_prod) {
        this.id_prod = id_prod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchatKey achatKey = (AchatKey) o;
        return Objects.equals(id_cli, achatKey.id_cli) &&
                Objects.equals(id_prod, achatKey.id_prod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cli, id_prod);
    }
}

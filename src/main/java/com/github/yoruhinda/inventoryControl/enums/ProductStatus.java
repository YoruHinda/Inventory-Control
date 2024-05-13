package com.github.yoruhinda.inventoryControl.enums;

import java.io.Serializable;

public enum ProductStatus implements Serializable {
    OUT_OF_STOCK, IN_STOCK;

    public String getStatus(){
        return this.name();
    }
}

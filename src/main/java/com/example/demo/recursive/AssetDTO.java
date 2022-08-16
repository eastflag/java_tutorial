package com.example.demo.recursive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AssetDTO {
    private Integer assetId;
    private Integer parentAssetId;
    private String name;
    private List<AssetDTO> children;

    public AssetDTO(Integer assetId, Integer parentAssetId, String name) {
        this.assetId = assetId;
        this.parentAssetId = parentAssetId;
        this.name = name;
    }
}

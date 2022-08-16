package com.example.demo.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecursiveTest {
    public static void main(String[] args) {
        List<AssetDTO> assetList = new ArrayList<>();
        assetList.add(new AssetDTO(1, 0, "AAA"));
        assetList.add(new AssetDTO(2, 0, "BBB"));
        assetList.add(new AssetDTO(3, 0, "CCC"));
        assetList.add(new AssetDTO(4, 1, "AAAa"));
        assetList.add(new AssetDTO(5, 1, "AAAb"));
        assetList.add(new AssetDTO(6, 4, "AAAa1"));
        assetList.add(new AssetDTO(7, 4, "AAAa2"));
        assetList.add(new AssetDTO(8, 4, "AAAa3"));

        List<AssetDTO> assetTree = new ArrayList<>();

        for (AssetDTO asset : assetList) {
            if (asset.getParentAssetId() == 0) {
                List<AssetDTO> children = getChildren(assetList, asset.getAssetId());
                asset.setChildren(children);
                assetTree.add(asset);
            }
        }

        System.out.println(assetTree);
    }

    static private List<AssetDTO> getChildren(List<AssetDTO> assetList, Integer parentAssetId) {
        List<AssetDTO> children = assetList.stream().filter(assetDTO -> assetDTO.getParentAssetId() == parentAssetId)
                .collect(Collectors.toList());
        for (AssetDTO asset : children) {
            List<AssetDTO> tempChildren =getChildren(assetList, asset.getAssetId());
            asset.setChildren(tempChildren);
        }
        return children;
    }
}

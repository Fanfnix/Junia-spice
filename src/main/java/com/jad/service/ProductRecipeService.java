package com.jad.service;

import com.jad.connector.DBConnector;
import com.jad.entity.Product;
import com.jad.entity.ProductRecipe;
import com.jad.entity.RecipeLine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRecipeService extends AbstractService {
    public ProductRecipeService(final DBConnector dbConnector) {
        super(dbConnector);
    }

    public List<ProductRecipe> getAll() throws SQLException {
        final Statement statement = this.getStatement();
        List<ProductRecipe> productRecipes = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * " +
                        "FROM ProductRecipe " +
                        "INNER JOIN RecipeLine ON ProductRecipe.id_Product = RecipeLine.id_Product " +
                        "ORDER BY ProductRecipe.id_Product");
        List<RecipeLine> recipeLines = new ArrayList<>();
        Integer currentIdProduct = null;
        Integer currentIdOperationType = null;
        for (int i = 0; resultSet.next(); i++) {
            if (currentIdProduct == null) {
                currentIdProduct = resultSet.getInt("id_Product");
                currentIdOperationType = resultSet.getInt("id_OperationType");
            } else if (currentIdProduct != resultSet.getInt("id_Product")) {
                productRecipes.add(new ProductRecipe(currentIdProduct,
                                                     currentIdOperationType,
                                                     recipeLines));
                recipeLines = new ArrayList<>();
                currentIdProduct = resultSet.getInt("id_Product");
                currentIdOperationType = resultSet.getInt("id_OperationType");
            }
            recipeLines.add(new RecipeLine(resultSet.getInt("id_Product"),
                                           resultSet.getInt("id_Component"),
                                           resultSet.getFloat("percentage")));
        }
        return productRecipes;
    }

    public ProductRecipe getByProduct(final Product product) throws SQLException {
        return this.getByIdProduct(product.getId());
    }

    public ProductRecipe getByIdProduct(final int id) throws SQLException {
        final Statement statement = this.getStatement();
        List<RecipeLine> recipeLines = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * " +
                        "FROM ProductRecipe  " +
                        "INNER JOIN RecipeLine ON ProductRecipe.id_Product = RecipeLine.id_Product " +
                        "WHERE ProductRecipe.id_Product = " + id);

        Integer currentIdProduct = null;
        Integer currentIdOperationType = null;
        for (int i = 0; resultSet.next(); i++) {
            if (currentIdProduct == null) {
                currentIdProduct = resultSet.getInt("id_Product");
                currentIdOperationType = resultSet.getInt("id_OperationType");
            }
            recipeLines.add(new RecipeLine(resultSet.getInt("id_Product"),
                                           resultSet.getInt("id_Component"),
                                           resultSet.getFloat("percentage")));
        }
        return new ProductRecipe(currentIdProduct,
                                 currentIdOperationType,
                                 recipeLines);
    }
}

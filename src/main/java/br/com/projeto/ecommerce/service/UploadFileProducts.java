package br.com.projeto.ecommerce.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.ecommerce.entity.ProductEntity;
import br.com.projeto.ecommerce.exception.ProductException;
import br.com.projeto.ecommerce.repository.ProductRepository;

@Service
public class UploadFileProducts {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> uploadFile(MultipartFile file) throws IOException {
        List<ProductEntity> products = new ArrayList<>();
        try {
            //Recuperando o arquivo
            FileInputStream inputStream = (FileInputStream) file.getInputStream();
            Workbook wb = new XSSFWorkbook(inputStream);

            //Setando a aba
            Sheet sheet = wb.getSheetAt(0);
            iterandoPlanilha(sheet);

        } catch (ProductException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<?> toList(Iterator<?> iterator){
        return IteratorUtils.toList(iterator);
    }

    private void iterandoPlanilha(Sheet sheet) {
        //Setando as linhas
        List<Row> rows = (List<Row>) toList(sheet.iterator());

        rows.remove(0);

        rows.forEach(row -> {
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());

            ProductEntity product = productRepository.getByName(cells.get(0).getStringCellValue());
            if(product != null) {
                try {
                    product.setBrand(cells.get(1).getStringCellValue());
                    product.setProductType(cells.get(2).getStringCellValue());
                    product.setUnitCost(new BigDecimal(cells.get(4).getStringCellValue()));
                    product.setUnitPrice(new BigDecimal(cells.get(3).getStringCellValue()));
                    product.setInsertProductDate(LocalDateTime.parse(cells.get(5).getStringCellValue()));
                    product.setDesc(cells.get(6).getStringCellValue());

                    this.productRepository.save(product);
                } catch (ProductException e) {
                    e.getMessage();
                }
            } else {
                try{
                    ProductEntity product2 = new ProductEntity();
                    product2.setName(cells.get(0).getStringCellValue());
                    product2.setBrand(cells.get(1).getStringCellValue());
                    product2.setProductType(cells.get(2).getStringCellValue());
                    product2.setUnitCost(new BigDecimal(cells.get(4).getStringCellValue()));
                    product2.setUnitPrice(new BigDecimal(cells.get(3).getStringCellValue()));
                    product2.setInsertProductDate(LocalDateTime.parse(cells.get(5).getStringCellValue()));
                    product2.setDesc(cells.get(6).getStringCellValue());

                    this.productRepository.save(product2);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

package br.com.projeto.ecommerce.mapper;

import br.com.projeto.ecommerce.entity.ProdutoEntity;
import br.com.projeto.ecommerce.vo.v1.ProdutoVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por fazer a conversão de uma Entidade em VO e vice-versa
 */


public class ModelMapper {

//    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    static {
        mapper.createTypeMap(ProdutoEntity.class, ProdutoVO.class).addMapping(ProdutoEntity::getId, ProdutoVO::setKey);
        mapper.createTypeMap(ProdutoVO.class, ProdutoEntity.class).addMapping(ProdutoVO::getKey, ProdutoEntity::setId);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }

}

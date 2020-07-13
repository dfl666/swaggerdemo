package com.dongfl.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerDemoController.class);

    //1.商品添加
    //@PutMapping("add") 添加方法--restful风格
    @PutMapping("add")
    @ApiOperation(value = "商品新增")
    //正常业务时， 需要在category类里或者server层进行事务控制，控制层一般不进行业务控制的。
    //@Transactional(rollbackFor = Exception.class)
    //@RequestParam 接收页面中的请求的参数
    public Map<String, Object> addCategory(@RequestParam String name) {
        System.out.println("新增一个商品" + name);
        logger.info("开始新增某个商品信息");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "01");
        result.put("respMsg", "新增成功！");
        result.put("data", name);
        return result;
    }

    //2.商品修改
    //@PostMapping("update")  修改方法--restful风格
    @PostMapping("update")
    @ApiOperation(value = "商品修改", notes = "修改数据库中某个的商品信息")
    //@RequestBody 接收页面中的请求的参数对象（适用于post请求）
    //当入参为实体对象时，需要在方法上加@Valid或@Validated或者在参数前加@Valid或@Validated，或者在类上加@Validated
    public Map<String, Object> updateCategory(@RequestParam String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("新增一个商品" + id);
        result.put("respCode", "03");
        result.put("respMsg", "修改成功！");
        result.put("data", id);
        return result;

    }

    //3.商品删除
    //@DeleteMapping("/delete/{id}") 删除方法--restful风格
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除商品", notes = "商品删除")
    @ApiImplicitParam(name = "id", value = "商品ID", paramType = "path", required = true, dataType = "Integer")
    public Map<String, Object> deleteCategory(@PathVariable String id) throws Exception {   //@PathVariable 获取/delete/{id}中id
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("删除一个商品" + id);
            logger.info("开始删除某个商品信息");
            result.put("respCode", "01");
            result.put("respMsg", "删除成功！");
            result.put("data", id);
            return result;
    }

    //4.根据ID查询商品信息
    //@GetMapping("")  查询方法--restful风格
    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据id查询商品", notes = "查询数据库中某个的商品信息")
    @ApiImplicitParam(name = "id", value = "商品ID", paramType = "path", required = true, dataType = "Integer")
    public Map<String, Object> getCategory(@PathVariable String id) { //@PathVariable 获取/get/{id}中id
        logger.info("开始查询某个商品信息");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "01");
        result.put("respMsg", "查询成功！");
        result.put("data", id);
        return result;
    }
}

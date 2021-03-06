package cn.luvletter.in;

import cn.luvletter.base.BaseController;
import cn.luvletter.bean.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zephyr Ji
 * @ Description: TODO
 * @ Date 2018/3/29
 */
@RestController
@RequestMapping("/inStock")
public class InStockController extends BaseController {
    @Autowired
    private InStockService inStockService;
    /**
     * @Description: 获取入库单列表
     * @Date: 11:14 2018/3/29
     */
    @GetMapping("/list")
    public ApiResult getData(HttpServletRequest httpServletRequest){
        return inStockService.getInStock(httpServletRequest);
    }
    /**
     * @Description: 根据id获取入库单明细
     * @Date: 11:14 2018/3/29
     */
    @GetMapping("/list/{id}")
    public ApiResult getDtl(@PathVariable String id,  HttpServletRequest httpServletRequest){
        return inStockService.getInDtl(id, httpServletRequest);
    }
    @PostMapping("/list")
    public ApiResult uploadInStock(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest){
        return inStockService.uploadInStock(file, httpServletRequest);
    }
}

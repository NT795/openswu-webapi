package cn.swu.edu.opensource.openswu_webapi_jersey.main;

import cn.swu.edu.opensource.openswu_webapi_jersey.exceptions.ParameterException;
import cn.swu.edu.opensource.openswu_webapi_jersey.interfaces.Lookup;
import cn.swu.edu.opensource.openswu_webapi_jersey.library.BorrowInfoLookuper;
import cn.swu.edu.opensource.openswu_webapi_jersey.library.HistoryLookuper;
import cn.swu.edu.opensource.openswu_webapi_jersey.library.LibraryParameter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by 西南大学开源协会 陈思定  on 2016/8/31.
 * <p>
 * Email : sidingchan@gmail.com
 * <p>
 * 查询图书馆的信息。
 */

@Path("/library/{module}")
public class Library {

    @PathParam("module")
    String module;

    // 简单的策略模式,Lookup是实现查询的顶层接口
    private Lookup lookup;

    private static Log LOGGER = LogFactory.getLog(Library.class);
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(LibraryParameter libraryParameter) {

        LOGGER.info("Library : " + libraryParameter.toString());
        // FIXME this module have some problem in performance.
        switch (module) {
            case "borrowInfo":
                lookup = new BorrowInfoLookuper();
                break;
            case "history":
                lookup = new HistoryLookuper();
                break;
            default:
                throw new ParameterException("the path /"+ module+" is wrong.");
        }
        String res = lookup.lookup(libraryParameter);
        return res;
    }

}

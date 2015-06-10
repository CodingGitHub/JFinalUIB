package little.ant.common.admin.service;

import little.ant.common.model.SensitiveWord;
import little.ant.platform.annotation.MyTxProxy;
import little.ant.platform.constant.ConstantInit;
import little.ant.platform.dto.SplitPage;
import little.ant.platform.service.BaseService;
import little.ant.platform.tools.ToolDateTime;

import org.apache.log4j.Logger;

public class SensitiveWordService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(SensitiveWordService.class);
	
	public static final SensitiveWordService service = MyTxProxy.newProxy(SensitiveWordService.class);
	
	/**
	 * 分页
	 * @param splitPage
	 */
	public void list(SplitPage splitPage) {
		splitPageBySqlId(ConstantInit.db_dataSource_main, splitPage, SensitiveWord.sqlId_splitPage_select, SensitiveWord.sqlId_splitPage_from);
	}

	/**
	 * 保存
	 * @param sensitiveWord
	 * @param userIds
	 * @return
	 */
	public String save(SensitiveWord sensitiveWord, String userIds){
		sensitiveWord.set(SensitiveWord.column_createuser, userIds);
		sensitiveWord.set(SensitiveWord.column_createdate, ToolDateTime.getSqlTimestamp(null));
		sensitiveWord.set(SensitiveWord.column_isdelete, "0");
		sensitiveWord.save();
		return sensitiveWord.getPKValue();
	}

	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids){
		String[] idsArr = splitByComma(ids);
		for (String id : idsArr) {
			SensitiveWord.dao.deleteById(id);
		}
	}
	
}

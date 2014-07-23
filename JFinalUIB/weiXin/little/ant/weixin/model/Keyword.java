package little.ant.weixin.model;

import little.ant.pingtai.annotation.TableBind;
import little.ant.pingtai.model.BaseModel;

import org.apache.log4j.Logger;

@TableBind(tableName="wx_keyword")
public class Keyword extends BaseModel<Keyword> {
	
	private static final long serialVersionUID = 7513950057125407026L;

	private static Logger log = Logger.getLogger(Keyword.class);
	
	public static final Keyword dao = new Keyword();
	
}

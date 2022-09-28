package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum SubjectType {
  SUBJECT_TYPE_INDIVIDUAL("（个体户）：营业执照上的主体类型一般为个体户、个体工商户、个体经营"),
  SUBJECT_TYPE_ENTERPRISE("（企业）：营业执照上的主体类型一般为有限公司、有限责任公司；"),
  SUBJECT_TYPE_GOVERNMENT("（政府机关）：包括各级、各类政府机关，如机关党委、税务、民政、人社、工商、商务、市监等；"),
  SUBJECT_TYPE_INSTITUTIONS("（事业单位）：包括国内各类事业单位，如：医疗、教育、学校等单位；"),
  SUBJECT_TYPE_OTHERS("（社会组织）： 包括社会团体、民办非企业、基金会、基层群众性自治组织、农村集体经济组织等组织。");


  private String desc;

  private SubjectType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}

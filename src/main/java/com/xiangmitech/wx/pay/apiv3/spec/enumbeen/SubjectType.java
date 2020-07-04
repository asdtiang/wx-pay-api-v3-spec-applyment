package com.xiangmitech.wx.pay.apiv3.spec.enumbeen;

/**
 * @author abel lee
 * @create 2020-05-25 11:16
 **/
public enum SubjectType {
  SUBJECT_TYPE_INDIVIDUAL("（个体户）：营业执照上的主体类型一般为个体户、个体工商户、个体经营"),
  SUBJECT_TYPE_ENTERPRISE("（企业）：营业执照上的主体类型一般为有限公司、有限责任公司；"),
  SUBJECT_TYPE_INSTITUTIONS("（党政、机关及事业单位）：包括国内各级、各类政府机构、事业单位等（如：公安、党团、司法、交通、旅游、工商税务、市政、医疗、教育、学校等机构）；"),
  SUBJECT_TYPE_OTHERS("（其他组织）：不属于企业、政府/事业单位的组织机构（如社会团体、民办非企业、基金会），要求机构已办理组织机构代码证。");


  private String desc;

  private SubjectType(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

}

package idroid.app.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.llsmpdroid.belief.base.XActivity;
import cn.llsmpdroid.belief.manager.log.XLog;
import idroid.app.R;

public class MainActivity extends XActivity {


    @Override
    public void onInitialization(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn1)
    public void onClick() {
        XLog.d("xxxx","aaa");
        XLog.json("{\n" +
                "  \"content\": [\n" +
                "    {\n" +
                "      \"fName\": \"XZBM\",\n" +
                "      \"fNameCHS\": \"乡镇编码\",\n" +
                "      \"fType\": \"Char\",\n" +
                "      \"fLen\": \"20\",\n" +
                "      \"fDec\": \"0\",\n" +
                "      \"fKey\": \"true\",\n" +
                "      \"frequired\": \"true\",\n" +
                "      \"fcode\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fName\": \"XZMC\",\n" +
                "      \"fNameCHS\": \"乡镇名称\",\n" +
                "      \"fType\": \"Char\",\n" +
                "      \"fLen\": \"20\",\n" +
                "      \"fDec\": \"0\",\n" +
                "      \"fKey\": \"true\",\n" +
                "      \"frequired\": \"true\",\n" +
                "      \"fcode\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fName\": \"JZCBM\",\n" +
                "      \"fNameCHS\": \"建制村编码\",\n" +
                "      \"fType\": \"Char\",\n" +
                "      \"fLen\": \"20\",\n" +
                "      \"fDec\": \"0\",\n" +
                "      \"fKey\": \"true\",\n" +
                "      \"frequired\": \"true\",\n" +
                "      \"fcode\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fName\": \"JZCMC\",\n" +
                "      \"fNameCHS\": \"建制村名称\",\n" +
                "      \"fType\": \"Char\",\n" +
                "      \"fLen\": \"20\",\n" +
                "      \"fDec\": \"0\",\n" +
                "      \"fKey\": \"true\",\n" +
                "      \"frequired\": \"true\",\n" +
                "      \"fcode\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fName\": \"AJCHNXF\",\n" +
                "      \"fNameCHS\": \"按建筑材料和使用年限分\",\n" +
                "      \"fType\": \"Char\",\n" +
                "      \"fLen\": \"1\",\n" +
                "      \"fDec\": \"0\",\n" +
                "      \"fKey\": \"false\",\n" +
                "      \"frequired\": \"false\",\n" +
                "      \"fcode\": \"TC_ajchnxf\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n");
    }
}

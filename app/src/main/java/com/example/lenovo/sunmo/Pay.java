package com.example.lenovo.sunmo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Lenovo on 5/5/2560.
 */
public class Pay extends Fragment {
    RequestQueue requestQueue;
    String JSON_STRING;
    TextView Pay;
    //private Spinner spinner;
    ArrayList<String> ar = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pay, container, false);
        new NukeSSLCerts().nuke();
        //Date = (TextView)rootView.findViewById(R.id.Date);
        Pay = (TextView)rootView.findViewById(R.id.Pay);
        //spinner = (Spinner) rootView.findViewById(spinner);
        //String text = " ";//= spinner.getSelectedItem().toString();
        String url = "https://10.51.4.17/TSP57/SMEs/index.php/account/reports/Api_android_sun/get_bacname";
        //url = url + "/" + text;
        //ID = (TextView)findViewById(R.id.code);
        //Issue = (TextView)findViewById(R.id.sub);
        requestQueue = Volley.newRequestQueue(getActivity());
        //ArrayList<String> schoolNames = new ArrayList<String>();
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,  "https://10.51.4.17/TSP57/SMEs/index.php/account/reports/Api_android_sun/get_pay",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("rs_bank");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject Hds_request = jsonArray.getJSONObject(i);

                                String bacNum = Hds_request.getString("bacNum");
                                String bacName = Hds_request.getString("bacName");
                                String baName = Hds_request.getString("baName");
                                String bacBranch = Hds_request.getString("bacBranch");
                                String bacNo = Hds_request.getString("bacNo");
                                String baCode = Hds_request.getString("baCode");
                                String cNo = Hds_request.getString("cNo");
                                String cDate = Hds_request.getString("cDate");
                                String deta_code = Hds_request.getString("deta_code");
                                String cAmount = Hds_request.getString("cAmount");
                                //ar.add(rq_code);
                                //String age = student.getString("age");

                                Pay.append(bacNum + " " +  bacName + "\n"
                                        + baName + " " + bacBranch + " \n" + bacNo +
                                        " " + baCode+"/"+cNo +"\n"
                                        + cDate +" " + deta_code +"\n" + cAmount+" THB\n"+"\n"
                                );
                                //schoolNames.append(rq_code + " " + " \n ");


                                //textView.append(rq_subject + " " + rq_code + " " + " \n ");

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY", "ERROR");
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
        // spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ar));
        //spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ar));

        return rootView;
    }

}

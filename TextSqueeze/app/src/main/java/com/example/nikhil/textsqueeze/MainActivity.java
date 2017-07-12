package com.example.nikhil.textsqueeze;
;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //String [] a = {" "};
    EditText editText;
    public final static String Data_Key = "com.example.nikhil.textsqueeze.data_key";
    public final static String Data_Key1 = "com.example.nikhil.textsqueeze.data_key1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String data1 = intent.getStringExtra(Data_Key1);

        editText = (EditText) findViewById(R.id.Edtxt);
        editText.setText(data1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void ClearBtn(View views){
        editText = (EditText) findViewById(R.id.Edtxt);
        editText.setText("");
    }

    public  void SqueezeBtn(View views) {
        editText = (EditText) findViewById(R.id.Edtxt);
        String data = editText.getText().toString();
        Intent intent = new Intent(this, Main2Activity.class);

        //Squeeze should happen here

        int i, N, h, k, j, sent_count, para_count, full_count, del_count, plus_count, fulls_count, reduce_count, z, z1;
        int counter, counta = 0, bounta = 0;


        String s = data;

        String errormsg = "NO INPUT PARAGRAPH DETECTED. PLEASE PASTE A PARAGRAPH OF MINIMUM 3 SENTENCES";

        if (s == null || s.indexOf(" ")== -1) {

            intent.putExtra(Data_Key, errormsg);
            startActivity(intent);

        }

        else {

            int len = s.length();
            String sj[] = new String[len];

                s = s.replace("\n", "");

            while (true) {
                if (s.contains("\n")) {
                    s = s.replaceFirst("\n", " ");
                } else {
                    break;
                }
            }

            if (s.contains("  "))                // to remove more than 1 spaces between sentences
            {
                for (i = 0; i < len - 1; i++) {
                    if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                        sj[bounta] = s.substring(0, i + 1);
                        s = s.substring(i + 1, len);
                        s = s.trim();
                        bounta++;
                        len = s.length();
                        i = 0;
                    }

                }
                sj[bounta] = s;
            }

            String s1;
            String sp="";
            if(bounta!=0)
            {
                for(i=0;i<(bounta+1);i++)
                {
                    sp=sp.concat(sj[i]);
                }
                s1=sp;
                s=sp;}
            else{
                s1=s;}

            String s2 = s1;
            String s3 = s1;
            String s4 = s1;
            String s5 = s1;
            String s6 = s1;

            int aan = 1;
            int ban = 3;

            int ep, count1 = 0;

            while (true) {
                ep = s2.indexOf(' ');
                if (ep != -1) {
                    count1++;
                    s2 = s2.substring(ep + 1);
                } else {
                    break;
                }
            }
            count1 = count1 + 1;
            N = count1;                                 // word length

            String r[] = new String[N];

            int T1, count2 = 0;
            int T2;

            while (true) {

                T1 = s3.indexOf('.');
                T2 = s3.lastIndexOf('.');
                if (T1 != -1 && T1 != T2) {
                    s3 = s3.substring(T1 + 1);
                    count2++;
                } else {
                    break;
                }
            }
            full_count = count2 + 1;                      // no of dots

            int T11, count3 = 0;


            while (true) {

                T11 = s4.indexOf(". ");
                if (T11 != -1) {
                    s4 = s4.substring(T11 + 1);
                    count3++;
                } else {
                    break;
                }
            }
            fulls_count = count3;                  // no of sentences

            int T111, T222, count4 = 0;

            for (i = 0; i < full_count; i++) {
                T111 = s5.indexOf('.');
                T222 = s5.lastIndexOf('.');
                if (s5.charAt(T111 - 1) == 'A' && T111 != T222 || s5.charAt(T111 - 1) == 'B' && T111 != T222 || s5.charAt(T111 - 1) == 'C' && T111 != T222 || s5.charAt(T111 - 1) == 'D' && T111 != T222 || s5.charAt(T111 - 1) == 'E' && T111 != T222 || s5.charAt(T111 - 1) == 'F' && T111 != T222 || s5.charAt(T111 - 1) == 'G' && T111 != T222 || s5.charAt(T111 - 1) == 'H' && T111 != T222 || s5.charAt(T111 - 1) == 'I' && T111 != T222 || s5.charAt(T111 - 1) == 'J' && T111 != T222 || s5.charAt(T111 - 1) == 'K' && T111 != T222 || s5.charAt(T111 - 1) == 'L' && T111 != T222 || s5.charAt(T111 - 1) == 'M' && T111 != T222 || s5.charAt(T111 - 1) == 'N' && T111 != T222 || s5.charAt(T111 - 1) == 'O' && T111 != T222 || s5.charAt(T111 - 1) == 'P' && T111 != T222 || s5.charAt(T111 - 1) == 'Q' && T111 != T222 || s5.charAt(T111 - 1) == 'R' && T111 != T222 || s5.charAt(T111 - 1) == 'S' && T111 != T222 || s5.charAt(T111 - 1) == 'T' && T111 != T222 || s5.charAt(T111 - 1) == 'U' && T111 != T222 || s5.charAt(T111 - 1) == 'V' && T111 != T222 || s5.charAt(T111 - 1) == 'W' && T111 != T222 || s5.charAt(T111 - 1) == 'X' && T111 != T222 || s5.charAt(T111 - 1) == 'Y' && T111 != T222 || s5.charAt(T111 - 1) == 'Z' && T111 != T222 || s5.charAt(T111 - 1) == '0' && T111 != T222 || s5.charAt(T111 - 1) == '1' && T111 != T222 || s5.charAt(T111 - 1) == '2' && T111 != T222 || s5.charAt(T111 - 1) == '3' && T111 != T222 || s5.charAt(T111 - 1) == '4' && T111 != T222 || s5.charAt(T111 - 1) == '5' && T111 != T222 || s5.charAt(T111 - 1) == '6' && T111 != T222 || s5.charAt(T111 - 1) == '7' && T111 != T222 || s5.charAt(T111 - 1) == '8' && T111 != T222 || s5.charAt(T111 - 1) == '9' && T111 != T222) {
                    count4++;
                    s5 = s5.substring(T111 + 1);
                } else {
                    s5 = s5.substring(T111 + 1);
                }
            }
            del_count = count4;                // sents to be delete

            int T12, count5 = 0;

            for (i = 0; i < fulls_count; i++) {
                T12 = s6.indexOf(". ");
                if (s6.charAt(T12 - 1) == '0' || s6.charAt(T12 - 1) == '1' || s6.charAt(T12 - 1) == '2' || s6.charAt(T12 - 1) == '3' || s6.charAt(T12 - 1) == '4' || s6.charAt(T12 - 1) == '5' || s6.charAt(T12 - 1) == '6' || s6.charAt(T12 - 1) == '7' || s6.charAt(T12 - 1) == '8' || s6.charAt(T12 - 1) == '9') {
                    count5++;
                    s6 = s6.substring(T12 + 1);
                } else {
                    s6 = s6.substring(T12 + 1);
                }
            }
            plus_count = count5;            // sents to be added to subtracted


            String str;
            String str1;
            String str2;

            for (i = 0; i < (N - 1); i++)          // putting sting in words convertion

            {
                h = s.indexOf(' ');
                str = s.substring(0, h);

                r[i] = str;

                s = s.substring(h + 1);

            }

            r[N - 1] = s;                   // end here conv


            for (j = 0; j < 3; j++)     // for (. collision elimination or other type elimination    //// smmothing process for words
            {
                for (i = 0; i < N; i++)   // for end dot nd other unwanted element elimination from words
                {
                    str2 = r[i];
                    k = r[i].length();

                    if (str2.charAt(0) == '“' || str2.charAt(0) == '"' || str2.charAt(0) == '(') {
                        r[i] = r[i].substring(1);

                    }


                    if ("a.i.".equals(r[i]) || "cwt.".equals(r[i]) || "c.".equals(r[i]) || "ca.".equals(r[i]) || "cca.".equals(r[i]) || "Cap.".equals(r[i]) || "cf.".equals(r[i]) || "cp.".equals(r[i]) || "ead.".equals(r[i]) || "al.".equals(r[i]) || "etc.".equals(r[i]) || "e.g.".equals(r[i]) || "fl.".equals(r[i]) || "f.".equals(r[i]) || "ff.".equals(r[i]) || "ibid.".equals(r[i]) || "id.".equals(r[i]) || "i.a.".equals(r[i]) || "i.e.".equals(r[i]) || "lb.".equals(r[i]) || "nem.".equals(r[i]) || "con.".equals(r[i]) || "op.".equals(r[i]) || "cit.".equals(r[i]) || "p.a.".equals(r[i]) || "cent.".equals(r[i]) || "Ph.D.".equals(r[i]) || "p.m.a.".equals(r[i]) || "p.p.".equals(r[i]) || "pro.".equals(r[i]) || "tem.".equals(r[i]) || "q.v.".equals(r[i]) || "r.".equals(r[i]) || "s.o.s.".equals(r[i]) || "Sic.".equals(r[i]) || "stat.".equals(r[i]) || "viz.".equals(r[i]) || "vs.".equals(r[i]) || "v.".equals(r[i]) || "Inc.".equals(r[i]) || "Ltd.".equals(r[i]) || "Co.".equals(r[i]) || "e.g.,".equals(r[i]) || "Abbr.".equals(r[i]) || "Adj.".equals(r[i]) || "Adv.".equals(r[i]) || "Obj.".equals(r[i]) || "Pl.".equals(r[i]) || "Poss.".equals(r[i]) || "Prep.".equals(r[i]) || "Pron.".equals(r[i]) || "Pseud.".equals(r[i]) || "Sing.".equals(r[i]) || "Syn.".equals(r[i]) || "Trans.".equals(r[i]) || "V.".equals(r[i]) || " Vb.".equals(r[i]) || "Assn.".equals(r[i]) || "Ave.".equals(r[i]) || "Dept.".equals(r[i]) || "Est.".equals(r[i]) || "Hrs.".equals(r[i]) || "Mt.".equals(r[i]) || "Oz.".equals(r[i]) || "Vs.".equals(r[i]) || "Sr.".equals(r[i]) || "Jr.".equals(r[i]) || "a.m.".equals(r[i]) || "p.m.".equals(r[i]) || "Dr.".equals(r[i]) || "Gen.".equals(r[i]) || "Hon.".equals(r[i]) || "Mr.".equals(r[i]) || "Mrs.".equals(r[i]) || "Ms.".equals(r[i]) || "Prof.".equals(r[i]) || "Rev.".equals(r[i]) || "St.".equals(r[i]) || "Sq.".equals(r[i]) || "No.".equals(r[i]) || "Fig.".equals(r[i])) {
                        continue;
                    }

                    if (str2.charAt(k - 1) == '.' || str2.charAt(k - 1) == ',' || str2.charAt(k - 1) == ';' || str2.charAt(k - 1) == ':' || str2.charAt(k - 1) == '"' || str2.charAt(k - 1) == '”' || str2.charAt(k - 1) == ')') {
                        r[i] = r[i].substring(0, k - 1);

                    }

                }
            }                            // smoothing ends here

            String r1[] = new String[N];

            r1 = r;

            int count6 = 0;
            String strr = "- – aboard about above across after against along amid among anti around as at before behind below beneath beside besides between beyond but by concerning considering despite down during except excepting excluding following for from in inside into like minus near of off on onto opposite outside over past per plus regarding round save since than through to toward towards under underneath unlike until up upon versus via with within without and that but or as if when than because while where after so though since until whether before although nor like once unless now except all another any anybody anyone anything both each either everybody everyone everything few he her hers herself him himself his it its itself many me mine more most much my myself neither no one nobody none nothing other others our ours ourselves several she some somebody someone something that their theirs them themselves these they this those we what whatever which whichever who whoever whom whomever whose you your yours yourself yourselves us is are am were was being been does did have had has can could may might will would shall should must ought i'll 1 2 3 4 5 6 7 8 9 0 however the a an Aboard About Above Across After Against Along Amid Among Anti Around As At Before Behind Below Beneath Beside Besides Between Beyond But By Concerning Considering Despite Down During Except Excepting Excluding Following For From In Inside Into Like Minus Near Of Off On Onto Opposite Outside Over Past Per Plus Regarding Round Save Since Than Through To Toward Towards Under Underneath Unlike Until Up Upon Versus Via With Within Without And That But Or As If When Than Because While Where After So Though Since Until Whether Before Although Nor Like Once Unless Now Except All Another Any Anybody Anyone Anything Both Each Either Everybody Everyone Everything Few He Her Hers Herself Him Himself His It Its Itself Many Me Mine More Most Much My Myself Neither No One Nobody None Nothing Other Others Our Ours Ourselves Several She Some Somebody Someone Something That Their Theirs Them Themselves These They This Those We What Whatever Which Whichever Who Whoever Whom Whomever Whose You Your Yours Yourself Yourselves Us Is Are Am Were Was Being Been Does Did Have Had Has Can Could May Might Will Would Shall Should Must Ought I'll However A The An A. B. C. D. E. F. G. H. I. J. K. L. M. N. O. P. Q. R. S. T. U. V. W. X. Y. Z. A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0 & @ # $ % * - = + / ? ! : ; ~";

            for (i = 0; i < N; i++) {
                if (!strr.contains(r[i])) {
                    count6++;
                }
            }

            counter = count6;               // counter


            int count7 = 0;
            for (i = 0; i < N; i++) {
                if ("a.i.".equals(r1[i]) || "cwt.".equals(r1[i]) || "c.".equals(r1[i]) || "ca.".equals(r1[i]) || "cca.".equals(r1[i]) || "Cap.".equals(r1[i]) || "cf.".equals(r1[i]) || "cp.".equals(r1[i]) || "ead.".equals(r1[i]) || "al.".equals(r1[i]) || "etc.".equals(r1[i]) || "e.g.".equals(r1[i]) || "fl.".equals(r1[i]) || "f.".equals(r1[i]) || "ff.".equals(r1[i]) || "ibid.".equals(r1[i]) || "id.".equals(r1[i]) || "i.a.".equals(r1[i]) || "i.e.".equals(r1[i]) || "lb.".equals(r1[i]) || "nem.".equals(r1[i]) || "con.".equals(r1[i]) || "op.".equals(r1[i]) || "cit.".equals(r1[i]) || "p.a.".equals(r1[i]) || "cent.".equals(r1[i]) || "Ph.D.".equals(r1[i]) || "p.m.a.".equals(r1[i]) || "p.p.".equals(r1[i]) || "pro.".equals(r1[i]) || "tem.".equals(r1[i]) || "q.v.".equals(r1[i]) || "r.".equals(r1[i]) || "s.o.s.".equals(r1[i]) || "Sic.".equals(r1[i]) || "stat.".equals(r1[i]) || "viz.".equals(r1[i]) || "vs.".equals(r1[i]) || "v.".equals(r1[i]) || "Ltd.".equals(r1[i]) || "Inc.".equals(r1[i]) || "Co.".equals(r1[i]) || "e.g.,".equals(r1[i]) || "Abbr.".equals(r1[i]) || "Adj.".equals(r1[i]) || "Adv.".equals(r1[i]) || "Obj.".equals(r1[i]) || "Pl.".equals(r1[i]) || "Poss.".equals(r1[i]) || "Prep.".equals(r1[i]) || "Pron.".equals(r1[i]) || "Pseud.".equals(r1[i]) || "Sing.".equals(r1[i]) || "Syn.".equals(r1[i]) || "Trans.".equals(r1[i]) || "V.".equals(r1[i]) || " Vb.".equals(r1[i]) || "Assn.".equals(r1[i]) || "Ave.".equals(r1[i]) || "Dept.".equals(r1[i]) || "Est.".equals(r1[i]) || "Hrs.".equals(r1[i]) || "Mt.".equals(r1[i]) || "Oz.".equals(r1[i]) || "Vs.".equals(r1[i]) || "Sr.".equals(r1[i]) || "Jr.".equals(r1[i]) || "a.m.".equals(r1[i]) || "p.m.".equals(r1[i]) || "Dr.".equals(r1[i]) || "Gen.".equals(r1[i]) || "Hon.".equals(r1[i]) || "Mr.".equals(r1[i]) || "Mrs.".equals(r1[i]) || "Ms.".equals(r1[i]) || "Prof.".equals(r1[i]) || "Rev.".equals(r1[i]) || "St.".equals(r1[i]) || "Sq.".equals(r1[i]) || "No.".equals(r1[i]) || "Fig.".equals(r1[i])) {
                    if ("a.i.".equals(r1[i]) || "e.g.".equals(r1[i]) || "i.a.".equals(r1[i]) || "i.e.".equals(r1[i]) || "p.a.".equals(r1[i]) || "p.p.".equals(r1[i]) || "q.v.".equals(r1[i]) || "p.m.a.".equals(r1[i]) || "s.o.s.".equals(r1[i]) || "e.g.,".equals(r1[i]) || "a.m.".equals(r1[i]) || "p.m.".equals(r1[i])) {
                        if ("p.m.a.".equals(r1[i]) || "s.o.s.".equals(r1[i])) {
                            count7 = count7 + 3;
                        } else {
                            count7 = count7 + 2;
                        }
                    } else {
                        count7++;
                    }
                } else {
                    continue;
                }
            }

            reduce_count = count7;              // latin count

            sent_count = full_count - (reduce_count + del_count) + plus_count;
            para_count = (int) ((sent_count * aan) / ban);

            s1 = s1.replaceAll(" a.i. ", " ai ");    ///////  sentence zone starts here
            s1 = s1.replaceAll(" cwt. ", " cwt ");
            s1 = s1.replaceAll(" c. ", " c ");
            s1 = s1.replaceAll(" cca. ", " cca ");
            s1 = s1.replaceAll(" Cap. ", " Capx ");
            s1 = s1.replaceAll(" cf. ", " cf ");
            s1 = s1.replaceAll(" cp. ", " cp ");
            s1 = s1.replaceAll(" ead. ", " ead ");
            s1 = s1.replaceAll(" et al. ", " et al ");
            s1 = s1.replaceAll(" etc. ", " etc ");
            s1 = s1.replaceAll(" fl. ", " fl ");
            s1 = s1.replaceAll(" ff. ", " ff ");
            s1 = s1.replaceAll(" id. ", " id ");
            s1 = s1.replaceAll(" i.e. ", " ie ");
            s1 = s1.replaceAll(" e.g. ", " eg ");
            s1 = s1.replaceAll(" f. ", " f ");
            s1 = s1.replaceAll(" ibid. ", " ibid ");
            s1 = s1.replaceAll(" i.a. ", " ia ");
            s1 = s1.replaceAll(" id. ", " id ");
            s1 = s1.replaceAll(" nem. ", " nem ");
            s1 = s1.replaceAll(" con. ", " con ");
            s1 = s1.replaceAll(" op. ", " op ");
            s1 = s1.replaceAll(" cit. ", " cit ");
            s1 = s1.replaceAll(" cent. ", " cent ");
            s1 = s1.replaceAll(" p.m.a. ", " pma ");
            s1 = s1.replaceAll(" p.p. ", " pp ");
            s1 = s1.replaceAll(" s.o.s. ", " sos ");
            s1 = s1.replaceAll(" sic. ", " sic ");
            s1 = s1.replaceAll(" r. ", " r ");
            s1 = s1.replaceAll(" pro. ", " Pro ");
            s1 = s1.replaceAll(" tem. ", " tem ");
            s1 = s1.replaceAll(" q.v. ", " qv ");
            s1 = s1.replaceAll(" stat. ", " stat ");
            s1 = s1.replaceAll(" Co. ", " Co ");
            s1 = s1.replaceAll(" viz. ", " viz ");
            s1 = s1.replaceAll(" vs. ", " vs ");
            s1 = s1.replaceAll(" v. ", " v ");
            s1 = s1.replaceAll(" Inc. ", " Inc ");
            s1 = s1.replaceAll(" Ltd. ", " Ltd ");
            s1 = s1.replaceAll(" p.a. ", " pa ");
            s1 = s1.replaceAll(" Ph.D. ", " PhD ");
            s1 = s1.replaceAll(" C.V. ", " CV ");
            s1 = s1.replaceAll(" D.V. ", " DV ");
            s1 = s1.replaceAll(" D.G. ", " DG ");
            s1 = s1.replaceAll(" J.D. ", " JD ");
            s1 = s1.replaceAll(" LL.B. ", " LLB ");
            s1 = s1.replaceAll(" M.A. ", " MA ");
            s1 = s1.replaceAll(" M.O. ", " MO ");
            s1 = s1.replaceAll(" N.B. ", " NB ");
            s1 = s1.replaceAll(" P.S. ", " PS ");
            s1 = s1.replaceAll(" Q.D. ", " QD ");
            s1 = s1.replaceAll(" Q.E.D. ", " QED ");
            s1 = s1.replaceAll(" B.A. ", " BA ");
            s1 = s1.replaceAll(" B.Sc. ", " BSc ");
            s1 = s1.replaceAll(" M.A. ", " MA ");
            s1 = s1.replaceAll(" M.B.A. ", " MBA ");
            s1 = s1.replaceAll(" M.B.B.S. ", " MBBS ");
            s1 = s1.replaceAll(" MD. ", " MD ");
            s1 = s1.replaceAll(" Abbr. ", " Abbr ");
            s1 = s1.replaceAll(" Adj. ", " Adj ");
            s1 = s1.replaceAll(" Adv. ", " Adv ");
            s1 = s1.replaceAll(" Obj. ", " Obj ");
            s1 = s1.replaceAll(" Pl. ", " Pl ");
            s1 = s1.replaceAll(" Poss. ", " Poss ");
            s1 = s1.replaceAll(" Prep. ", " Prep ");
            s1 = s1.replaceAll(" Pron. ", " Pron ");
            s1 = s1.replaceAll(" Pseud. ", " Pseud ");
            s1 = s1.replaceAll(" Sing. ", " Sing ");
            s1 = s1.replaceAll(" Syn. ", " Syn ");
            s1 = s1.replaceAll(" Trans. ", " Trans ");
            s1 = s1.replaceAll(" Vb. ", " Vb ");
            s1 = s1.replaceAll(" Assn. ", " Assn ");
            s1 = s1.replaceAll(" Ave. ", " Ave ");
            s1 = s1.replaceAll(" Dept. ", " Dept ");
            s1 = s1.replaceAll(" Est. ", " Est ");
            s1 = s1.replaceAll(" Hrs. ", " Hrs ");
            s1 = s1.replaceAll(" Mt. ", " Mt ");
            s1 = s1.replaceAll(" Oz. ", " Oz ");
            s1 = s1.replaceAll(" Vs. ", " Vs ");
            s1 = s1.replaceAll(" Sr. ", " Sr ");
            s1 = s1.replaceAll(" Jr. ", " Jr ");
            s1 = s1.replaceAll(" a.m. ", " am ");
            s1 = s1.replaceAll(" p.m. ", " pm ");
            s1 = s1.replaceAll(" A.M. ", " AM ");    //   for sent only
            s1 = s1.replaceAll(" P.M. ", " PM ");    //   for sent only
            s1 = s1.replaceAll(" R.I.P. ", " RIP ");   //  for sent only
            s1 = s1.replaceAll(" Dr. ", " Dr ");///
            s1 = s1.replaceAll(" Gen. ", " Gen ");///
            s1 = s1.replaceAll(" Hon. ", " Hon ");///
            s1 = s1.replaceAll(" Mr. ", " Mr ");///
            s1 = s1.replaceAll(" Ms. ", " Ms ");
            s1 = s1.replaceAll(" Mrs. ", " Mrs ");///
            s1 = s1.replaceAll(" Prof. ", " Prof ");///
            s1 = s1.replaceAll(" Rev. ", " Rev ");///
            s1 = s1.replaceAll(" St. ", " St ");///
            s1 = s1.replaceAll(" Fig. ", " Fig ");///
            s1 = s1.replaceAll(" No. ", " No ");///
            s1 = s1.replaceAll(" Sq. ", " Sq ");///


            String v[];
            v = new String[sent_count];
            for (i = 0; i < sent_count - 1; i++) {
                z = s1.indexOf(". ");


                while (true) {
                    if (s1.charAt(z - 1) == 'A' || s1.charAt(z - 1) == 'B' || s1.charAt(z - 1) == 'C' || s1.charAt(z - 1) == 'D' || s1.charAt(z - 1) == 'E' || s1.charAt(z - 1) == 'F' || s1.charAt(z - 1) == 'G' || s1.charAt(z - 1) == 'H' || s1.charAt(z - 1) == 'I' || s1.charAt(z - 1) == 'J' || s1.charAt(z - 1) == 'K' || s1.charAt(z - 1) == 'L' || s1.charAt(z - 1) == 'M' || s1.charAt(z - 1) == 'N' || s1.charAt(z - 1) == 'O' || s1.charAt(z - 1) == 'P' || s1.charAt(z - 1) == 'Q' || s1.charAt(z - 1) == 'R' || s1.charAt(z - 1) == 'S' || s1.charAt(z - 1) == 'T' || s1.charAt(z - 1) == 'U' || s1.charAt(z - 1) == 'V' || s1.charAt(z - 1) == 'W' || s1.charAt(z - 1) == 'X' || s1.charAt(z - 1) == 'Y' || s1.charAt(z - 1) == 'Z') {
                        if (s1.charAt(z - 1) == 'A') {
                            s1 = s1.replaceFirst("A. ", "A ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'B') {
                            s1 = s1.replaceFirst("B. ", "B ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'C') {
                            s1 = s1.replaceFirst("C. ", "C ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'D') {
                            s1 = s1.replaceFirst("D. ", "D ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'E') {
                            s1 = s1.replaceFirst("E. ", "E ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'F') {
                            s1 = s1.replaceFirst("F. ", "F ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'G') {
                            s1 = s1.replaceFirst("G. ", "G ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'H') {
                            s1 = s1.replaceFirst("H. ", "H ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'I') {
                            s1 = s1.replaceFirst("I. ", "I ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'J') {
                            s1 = s1.replaceFirst("J. ", "J ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'K') {
                            s1 = s1.replaceFirst("K. ", "K ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'L') {
                            s1 = s1.replaceFirst("L. ", "L ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'M') {
                            s1 = s1.replaceFirst("M. ", "M ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'N') {
                            s1 = s1.replaceFirst("N. ", "N ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'O') {
                            s1 = s1.replaceFirst("O. ", "O ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'P') {
                            s1 = s1.replaceFirst("P. ", "P ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'Q') {
                            s1 = s1.replaceFirst("Q. ", "Q ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'R') {
                            s1 = s1.replaceFirst("R. ", "R ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'S') {
                            s1 = s1.replaceFirst("S. ", "S ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'T') {
                            s1 = s1.replaceFirst("T. ", "T ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'U') {
                            s1 = s1.replaceFirst("U. ", "U ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'V') {
                            s1 = s1.replaceFirst("V. ", "V ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'W') {
                            s1 = s1.replaceFirst("W. ", "W ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'X') {
                            s1 = s1.replaceFirst("X. ", "X ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'Y') {
                            s1 = s1.replaceFirst("Y. ", "Y ");

                            z = s1.indexOf(". ");
                            continue;
                        }

                        if (s1.charAt(z - 1) == 'Z') {
                            s1 = s1.replaceFirst("Z. ", "Z ");

                            z = s1.indexOf(". ");
                        }
                    } else {

                        break;

                    }
                }

                str1 = s1.substring(0, z);
                v[i] = str1;
                s1 = s1.substring(z + 2);

            }
            z1 = s1.lastIndexOf(".");
            s1 = s1.substring(0, z1);
            v[sent_count - 1] = s1;


            for (i = 0; i < sent_count; i++) {
                v[i] = v[i].replaceAll(" ai ", " a.i. ");
                v[i] = v[i].replaceAll(" cwt ", " cwt. ");
                v[i] = v[i].replaceAll(" c ", " c. ");
                v[i] = v[i].replaceAll(" cca ", " cca. ");
                v[i] = v[i].replaceAll(" Capx ", " Cap. ");
                v[i] = v[i].replaceAll(" cf ", " cf. ");
                v[i] = v[i].replaceAll(" cp ", " cp. ");
                v[i] = v[i].replaceAll(" ead ", " ead. ");
                v[i] = v[i].replaceAll(" et al ", " et al. ");
                v[i] = v[i].replaceAll(" etc ", " etc. ");
                v[i] = v[i].replaceAll(" fl ", " fl. ");
                v[i] = v[i].replaceAll(" ff ", " ff. ");
                v[i] = v[i].replaceAll(" id ", " id. ");
                v[i] = v[i].replaceAll(" ie ", " i.e. ");
                v[i] = v[i].replaceAll(" eg ", " e.g. ");
                v[i] = v[i].replaceAll(" f ", " f. ");
                v[i] = v[i].replaceAll(" ibid ", " ibid. ");
                v[i] = v[i].replaceAll(" ia ", " i.a. ");
                v[i] = v[i].replaceAll(" id ", " id. ");
                v[i] = v[i].replaceAll(" nem ", " nem. ");
                v[i] = v[i].replaceAll(" con ", " con. ");
                v[i] = v[i].replaceAll(" op ", " op. ");
                v[i] = v[i].replaceAll(" cit ", " cit. ");
                v[i] = v[i].replaceAll(" cent ", " cent. ");
                v[i] = v[i].replaceAll(" pma ", " p.m.a. ");
                v[i] = v[i].replaceAll(" pp ", " p.p. ");
                v[i] = v[i].replaceAll(" sos ", " s.o.s. ");
                v[i] = v[i].replaceAll(" sic ", " sic. ");
                v[i] = v[i].replaceAll(" r ", " r. ");
                v[i] = v[i].replaceAll(" pro ", " Pro. ");
                v[i] = v[i].replaceAll(" tem ", " tem. ");
                v[i] = v[i].replaceAll(" qv ", " q.v. ");
                v[i] = v[i].replaceAll(" stat ", " stat. ");
                v[i] = v[i].replaceAll(" Co ", " Co. ");
                v[i] = v[i].replaceAll(" viz ", " viz. ");
                v[i] = v[i].replaceAll(" vs ", " vs. ");
                v[i] = v[i].replaceAll(" v ", " v. ");
                v[i] = v[i].replaceAll(" Inc ", " Inc. ");
                v[i] = v[i].replaceAll(" Ltd ", " Ltd. ");
                v[i] = v[i].replaceAll(" pa ", " p.a. ");
                v[i] = v[i].replaceAll("pa ", "p.a. ");
                v[i] = v[i].replaceAll(" PhD ", " Ph.D. ");
                v[i] = v[i].replaceAll("PhD ", "Ph.D. ");
                v[i] = v[i].replaceAll(" CV ", " C.V. ");
                v[i] = v[i].replaceAll(" DV ", " D.V. ");
                v[i] = v[i].replaceAll(" DG ", " D.G. ");
                v[i] = v[i].replaceAll(" JD ", " J.D. ");
                v[i] = v[i].replaceAll(" LLB ", " LL.B. ");
                v[i] = v[i].replaceAll("LLB ", "LL.B. ");
                v[i] = v[i].replaceAll(" MA ", " M.A. ");
                v[i] = v[i].replaceAll("MA ", "M.A. ");
                v[i] = v[i].replaceAll(" MO ", " M.O. ");
                v[i] = v[i].replaceAll(" NB ", " N.B. ");
                v[i] = v[i].replaceAll(" PS ", " P.S. ");
                v[i] = v[i].replaceAll(" QD ", " Q.D. ");
                v[i] = v[i].replaceAll(" QED ", " Q.E.D. ");
                v[i] = v[i].replaceAll(" BA ", " B.A. ");
                v[i] = v[i].replaceAll("BA ", "B.A. ");
                v[i] = v[i].replaceAll(" BSc ", " B.Sc. ");
                v[i] = v[i].replaceAll("BSc ", "B.Sc. ");
                v[i] = v[i].replaceAll(" MA ", " M.A. ");
                v[i] = v[i].replaceAll("MA ", "M.A. ");
                v[i] = v[i].replaceAll(" MBA ", " M.B.A. ");
                v[i] = v[i].replaceAll("MBA ", "M.B.A. ");
                v[i] = v[i].replaceAll(" MBBS ", " M.B.B.S. ");
                v[i] = v[i].replaceAll("MBBS ", "M.B.B.S. ");
                v[i] = v[i].replaceAll(" MD ", " MD. ");
                v[i] = v[i].replaceAll("MD ", "MD. ");
                v[i] = v[i].replaceAll(" Abbr ", " Abbr. ");
                v[i] = v[i].replaceAll(" Adj ", " Adj. ");
                v[i] = v[i].replaceAll(" Adv ", " Adv. ");
                v[i] = v[i].replaceAll(" Obj ", " Obj. ");
                v[i] = v[i].replaceAll(" Pl ", " Pl. ");
                v[i] = v[i].replaceAll(" Poss ", " Poss. ");
                v[i] = v[i].replaceAll(" Prep ", " Prep. ");
                v[i] = v[i].replaceAll(" Pron ", " Pron. ");
                v[i] = v[i].replaceAll(" Pseud ", " Pseud. ");
                v[i] = v[i].replaceAll(" Sing ", " Sing. ");
                v[i] = v[i].replaceAll(" Syn ", " Syn. ");
                v[i] = v[i].replaceAll(" Trans ", " Trans. ");
                v[i] = v[i].replaceAll(" Vb ", " Vb. ");
                v[i] = v[i].replaceAll(" Assn ", " Assn. ");
                v[i] = v[i].replaceAll(" Ave ", " Ave. ");
                v[i] = v[i].replaceAll(" Dept ", " Dept. ");
                v[i] = v[i].replaceAll("Dept ", "Dept. ");
                v[i] = v[i].replaceAll(" Est ", " Est. ");
                v[i] = v[i].replaceAll(" Hrs ", " Hrs. ");
                v[i] = v[i].replaceAll(" Mt ", " Mt. ");
                v[i] = v[i].replaceAll(" Oz ", " Oz. ");
                v[i] = v[i].replaceAll(" Vs ", " Vs. ");
                v[i] = v[i].replaceAll(" Sr ", " Sr. ");
                v[i] = v[i].replaceAll("Sr ", "Sr. ");
                v[i] = v[i].replaceAll(" Jr ", " Jr. ");
                v[i] = v[i].replaceAll("Jr ", "Jr. ");
                v[i] = v[i].replaceAll(" am ", " a.m. ");
                v[i] = v[i].replaceAll(" pm ", " p.m. ");
                v[i] = v[i].replaceAll(" AM ", " A.M. ");    //   for sent only
                v[i] = v[i].replaceAll(" PM ", " P.M. ");    //   for sent only
                v[i] = v[i].replaceAll(" RIP ", " R.I.P. ");   //  for sent only
                v[i] = v[i].replaceAll("RIP ", "R.I.P. ");
                v[i] = v[i].replaceAll(" Dr ", " Dr. ");///
                v[i] = v[i].replaceAll("Dr ", "Dr. ");
                v[i] = v[i].replaceAll(" Gen ", " Gen. ");///
                v[i] = v[i].replaceAll(" Hon ", " Hon. ");///
                v[i] = v[i].replaceAll("Hon ", "Hon. ");
                v[i] = v[i].replaceAll(" Mr ", " Mr. ");///
                v[i] = v[i].replaceAll("Mr ", "Mr. ");///
                v[i] = v[i].replaceAll(" Ms ", " Ms. ");
                v[i] = v[i].replaceAll(" Ms ", "Ms. ");
                v[i] = v[i].replaceAll(" Mrs ", " Mrs. ");///
                v[i] = v[i].replaceAll("Mrs ", "Mrs. ");
                v[i] = v[i].replaceAll(" Prof ", " Prof. ");///
                v[i] = v[i].replaceAll("Prof ", "Prof. ");
                v[i] = v[i].replaceAll(" Rev ", " Rev. ");///
                v[i] = v[i].replaceAll(" St ", " St. ");///
                v[i] = v[i].replaceAll("St ", "St. ");
                v[i] = v[i].replaceAll(" Fig ", " Fig. ");///
                v[i] = v[i].replaceAll("Fig ", "Fig. ");
                v[i] = v[i].replaceAll(" No ", " No. ");///
                v[i] = v[i].replaceAll(" Sq ", " Sq. ");
         /*v[i]=v[i].replaceAll("A ","A. ");
         v[i]=v[i].replaceAll("B ","B. ");
         v[i]=v[i].replaceAll("C ","C. ");
         v[i]=v[i].replaceAll("D ","D. ");
         v[i]=v[i].replaceAll("E ","E. ");
         v[i]=v[i].replaceAll("F ","F. ");
         v[i]=v[i].replaceAll("G ","G. ");
         v[i]=v[i].replaceAll("H ","H. ");
         v[i]=v[i].replaceAll("I ","I. ");
         v[i]=v[i].replaceAll("J ","J. ");
         v[i]=v[i].replaceAll("K ","K. ");
         v[i]=v[i].replaceAll("L ","L. ");
         v[i]=v[i].replaceAll("M ","M. ");
         v[i]=v[i].replaceAll("N ","N. ");
         v[i]=v[i].replaceAll("O ","O. ");
         v[i]=v[i].replaceAll("P ","P. ");
         v[i]=v[i].replaceAll("Q ","Q. ");
         v[i]=v[i].replaceAll("R ","R. ");
         v[i]=v[i].replaceAll("S ","S. ");
         v[i]=v[i].replaceAll("T ","T. ");
         v[i]=v[i].replaceAll("U ","U. ");
         v[i]=v[i].replaceAll("V ","V. ");
         v[i]=v[i].replaceAll("W ","W. ");
         v[i]=v[i].replaceAll("X ","X. ");
         v[i]=v[i].replaceAll("Y ","Y. ");
         v[i]=v[i].replaceAll("Z ","Z. ");
         */
            }                                                           // end of molule 1


            ArrayList<String> arey = new ArrayList<>(counter);         // selection of selected words  // start of module 2
            ArrayList mrey;
            mrey = new ArrayList<>(counter);
            int the1, man, the2, man2;

            String str3 = "- – aboard about above across after against along amid among anti around as at before behind below beneath beside besides between beyond but by concerning considering despite down during except excepting excluding following for from in inside into like minus near of off on onto opposite outside over past per plus regarding round save since than through to toward towards under underneath unlike until up upon versus via with within without and that but or as if when than because while where after so though since until whether before although nor like once unless now except all another any anybody anyone anything both each either everybody everyone everything few he her hers herself him himself his it its itself many me mine more most much my myself neither no one nobody none nothing other others our ours ourselves several she some somebody someone something that their theirs them themselves these they this those we what whatever which whichever who whoever whom whomever whose you your yours yourself yourselves us is are am were was being been does did Have had has can could may might will would shall should must ought i'll 1 2 3 4 5 6 7 8 9 0 however the a an Aboard About Above Across After Against Along Amid Among Anti Around As At Before Behind Below Beneath Beside Besides Between Beyond But By Concerning Considering Despite Down During Except Excepting Excluding Following For From In Inside Into Like Minus Near Of Off On Onto Opposite Outside Over Past Per Plus Regarding Round Save Since Than Through To Toward Towards Under Underneath Unlike Until Up Upon Versus Via With Within Without And That But Or As If When Than Because While Where After So Though Since Until Whether Before Although Nor Like Once Unless Now Except All Another Any Anybody Anyone Anything Both Each Either Everybody Everyone Everything Few He Her Hers Herself Him Himself His It Its Itself Many Me Mine More Most Much My Myself Neither No One Nobody None Nothing Other Others Our Ours Ourselves Several She Some Somebody Someone Something That Their Theirs Them Themselves These They This Those We What Whatever Which Whichever Who Whoever Whom Whomever Whose You Your Yours Yourself Yourselves Us Is Are Am Were Was Being Been Does Did Have Had Has Can Could May Might Will Would Shall Should Must Ought I'll However A The An A. B. C. D. E. F. G. H. I. J. K. L. M. N. O. P. Q. R. S. T. U. V. W. X. Y. Z. A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0 & @ # $ % * - = + / ? ! : ; ~";

            for (i = 0; i < N; i++) {
                if (!str3.contains(r[i])) {
                    arey.add(r[i]);
                }
            }


            String str4;

// smothing of selected words
            for (i = 0; i < counter; i++) {
                str4 = arey.get(i);
                k = str4.length();

                if (str4.charAt(k - 1) == 's') {
                    str4 = str4.substring(0, k - 1);
                    arey.set(i, str4);
                }
                if (str4.charAt(k - 2) == '’') {
                    str4 = str4.substring(0, k - 2);
                    arey.set(i, str4);
                }

            }
            // end of smoothing of selected words


            for (i = 0; i < counter; i++)          // mst freq started
            {
                counta = 0;
                for (j = 0; j < counter; j++) {

                    if (arey.get(i).equals(arey.get(j))) {
                        counta++;
                    }

                }
                mrey.add(counta);
            }


            the1 = (int) Collections.max(mrey);

            man = mrey.indexOf(the1);

            String mst_rep_wrd = arey.get(man);


            int lst_ind_of_mst = arey.lastIndexOf(mst_rep_wrd);    // removing process starting

            for (i = 0; i < the1; i++) {
                arey.remove(lst_ind_of_mst);
                lst_ind_of_mst = arey.lastIndexOf(mst_rep_wrd);
            }


            ArrayList prey;
            prey = new ArrayList<>(counter);


            for (i = 0; i < counter - the1; i++)    // second mst freq word search starts
            {
                counta = 0;
                for (j = 0; j < counter - the1; j++) {

                    if (arey.get(i).equals(arey.get(j))) {
                        counta++;
                    }

                }
                prey.add(counta);
            }

            the2 = (int) Collections.max(prey);
            man2 = prey.indexOf(the2);

            String mst_sec_rep_word = arey.get(man2);     // secnd mst freq wrd search ends

            counta++;           // invalid bt important line


            int subdiv;          // 3rd module code start here

            int a1 = 1, b1 = 11, i1 = 2;
            while (true) {
                if (a1 <= sent_count && b1 > sent_count) {
                    break;
                } else {
                    a1 = b1;
                    b1 = b1 + 100;
                    i1++;
                }
            }
            subdiv = i1;


            int e = para_count / subdiv;

            String summary[] = new String[sent_count];
            String output = "";
            int N5 = sent_count / subdiv;

            String sub1[] = new String[N5];
            String sub1a[] = new String[sent_count - N5];
            String sub2[] = new String[N5];
            String sub2a[] = new String[(sent_count - (2 * N5))];
/*String sub5[]=new String[N5];
String sub6[]=new String[N5];
String sub7[]=new String[N5];*/

            int temp = 0;
            String ac[] = new String[para_count];
            if (subdiv == 2) {
                for (i = 0; i < N5; i++)                // for assignment of sub1a
                {
                    sub1[i] = v[i];
                }


                for (i = N5; i < sent_count; i++)  // for sub1a
                {
                    j = temp;
                    sub1a[j] = v[i];
                    temp++;
                }


                String inside1[] = new String[N5];        // the three inside array declaration
                String inside2[] = new String[N5];
                String inside3[] = new String[N5];


                for (i = 0; i < N5; i++)               // the three inside array creation for sub1
                {
                    if (sub1[i].contains(mst_rep_wrd) && sub1[i].contains(mst_sec_rep_word)) {
                        inside1[i] = sub1[i];
                    }

                    if (sub1[i].contains(mst_rep_wrd) && !sub1[i].contains(mst_sec_rep_word)) {
                        inside2[i] = sub1[i];
                    }

                    if (sub1[i].contains(mst_sec_rep_word) && !sub1[i].contains(mst_rep_wrd)) {
                        inside3[i] = sub1[i];

                    }

                }


                int u = 0;

                for (i = 0; i < N5; i++) {
                    if (inside1[i] != null) {
                        summary[i] = inside1[i];
                        u++;
                        if (e == u) {
                            break;
                        }
                    }
                }

                if (e > u) {
                    for (i = 0; i < N5; i++) {
                        if (inside2[i] != null) {
                            summary[i] = inside2[i];

                            u++;
                            if (e == u) {
                                break;
                            }

                        }

                    }
                }


                if (e > u) {
                    for (i = 0; i < N5; i++) {
                        if (inside3[i] != null) {
                            summary[i] = inside3[i];

                            u++;
                            if (e == u) {
                                break;
                            }
                        }
                    }
                }

                int bemp = N5;

                String inside21[] = new String[sent_count];        // the three inside array declaration
                String inside22[] = new String[sent_count];
                String inside23[] = new String[sent_count];


                for (i = 0; i < (sent_count - N5); i++)               // the three inside array creation for sub1
                {
                    if (sub1a[i].contains(mst_rep_wrd) && sub1a[i].contains(mst_sec_rep_word)) {
                        j = bemp;
                        inside21[j] = sub1a[i];
                        bemp++;
                    }

                    if (sub1a[i].contains(mst_rep_wrd) && !sub1a[i].contains(mst_sec_rep_word)) {
                        j = bemp;
                        inside22[j] = sub1a[i];
                        bemp++;
                    }

                    if (sub1a[i].contains(mst_sec_rep_word) && !sub1a[i].contains(mst_rep_wrd)) {
                        j = bemp;
                        inside23[j] = sub1a[i];
                        bemp++;
                    }

                    if (!sub1a[i].contains(mst_sec_rep_word) && !sub1a[i].contains(mst_rep_wrd)) {
                        bemp++;
                    }


                }


                int e1 = para_count - e;                // done for every last subpara to fulfill odd requirements of no. of paracount
                int uu = 0;

                if (e > u) {
                    e1 = para_count - e + (e - u);
                }

                for (i = N5; i < sent_count; i++) {
                    if (inside21[i] != null) {
                        summary[i] = inside21[i];
                        uu++;
                        if (e1 == uu) {
                            break;
                        }
                    }
                }


                if (e1 > uu)
                    for (i = N5; i < sent_count; i++) {
                        if (inside22[i] != null) {
                            summary[i] = inside22[i];

                            uu++;
                            if (e1 == uu) {
                                break;
                            }

                        }

                    }


                if (e1 > uu)
                    for (i = N5; i < sent_count; i++) {
                        if (inside23[i] != null) {
                            summary[i] = inside23[i];

                            uu++;
                            if (e1 == uu) {
                                break;
                            }
                        }
                    }

                int kemp = 0;

                for (i = 0; i < sent_count; i++) {
                    if (summary[i] != null) {
                        j = kemp;
                        ac[j] = summary[i];
                        kemp++;

                        if (kemp == para_count) {
                            break;

                        }
                    }
                }


                for (i = 0; i < para_count; i++) {
                    if ((ac[i]) != null) {
                        output = output.concat(ac[i]);
                    }
                }


                intent.putExtra(Data_Key, output);
                startActivity(intent);

            }
//////////////////////////////////////////////////////////////////////////

            int gemp = 0;             //  for sentences more than 10-110
            int cemp = 0;
            String bc[] = new String[para_count];
            if (subdiv == 3) {
                for (i = 0; i < N5; i++)                // for assignment of sub1a
                {
                    sub1[i] = v[i];
                }


                for (i = N5; i < (2 * N5); i++)  // for sub2
                {
                    j = gemp;
                    sub2[j] = v[i];
                    gemp++;
                }

                for (i = (2 * N5); i < sent_count; i++)  // for sub2a
                {
                    j = cemp;
                    sub2a[j] = v[i];
                    cemp++;
                }


                String inside1a[] = new String[N5];        // the three inside array declaration
                String inside2a[] = new String[N5];
                String inside3a[] = new String[N5];


                for (i = 0; i < N5; i++)               // the three inside array creation for sub1
                {
                    if (sub1[i].contains(mst_rep_wrd) && sub1[i].contains(mst_sec_rep_word)) {
                        inside1a[i] = sub1[i];
                    }

                    if (sub1[i].contains(mst_rep_wrd) && !sub1[i].contains(mst_sec_rep_word)) {
                        inside2a[i] = sub1[i];
                    }

                    if (sub1[i].contains(mst_sec_rep_word) && !sub1[i].contains(mst_rep_wrd)) {
                        inside3a[i] = sub1[i];

                    }


                }

                int u1 = 0;

                for (i = 0; i < N5; i++) {
                    if (inside1a[i] != null) {
                        summary[i] = inside1a[i];
                        u1++;
                        if (e == u1) {
                            break;
                        }
                    }
                }

                if (e > u1) {
                    for (i = 0; i < N5; i++) {
                        if (inside2a[i] != null) {
                            summary[i] = inside2a[i];

                            u1++;
                            if (e == u1) {
                                break;
                            }

                        }

                    }
                }


                if (e > u1) {
                    for (i = 0; i < N5; i++) {
                        if (inside3a[i] != null) {
                            summary[i] = inside3a[i];

                            u1++;
                            if (e == u1) {
                                break;
                            }
                        }
                    }
                }

                int vemp = N5;

                String inside221[] = new String[(2 * N5)];        // the three inside array declaration
                String inside222[] = new String[(2 * N5)];
                String inside223[] = new String[(2 * N5)];


                for (i = 0; i < N5; i++)               // the three inside array creation for sub1
                {
                    if (sub2[i].contains(mst_rep_wrd) && sub2[i].contains(mst_sec_rep_word)) {
                        j = vemp;
                        inside221[j] = sub2[i];
                        vemp++;
                    }

                    if (sub2[i].contains(mst_rep_wrd) && !sub2[i].contains(mst_sec_rep_word)) {
                        j = vemp;
                        inside222[j] = sub2[i];
                        vemp++;
                    }

                    if (sub2[i].contains(mst_sec_rep_word) && !sub2[i].contains(mst_rep_wrd)) {
                        j = vemp;
                        inside223[j] = sub2[i];
                        vemp++;
                    }

                    if (!sub2[i].contains(mst_sec_rep_word) && !sub2[i].contains(mst_rep_wrd)) {
                        vemp++;
                    }


                }


                int y = 0;
                int e2 = e;
                if (e > u1) {
                    e2 = e + (e - u1);
                }

                for (i = N5; i < (2 * N5); i++) {
                    if (inside221[i] != null) {
                        summary[i] = inside221[i];
                        y++;
                        if (e2 == y) {
                            break;
                        }
                    }
                }


                if (e2 > y)
                    for (i = N5; i < (2 * N5); i++) {
                        if (inside222[i] != null) {
                            summary[i] = inside222[i];

                            y++;
                            if (e2 == y) {
                                break;
                            }

                        }

                    }


                if (e2 > y)
                    for (i = N5; i < (2 * N5); i++) {
                        if (inside223[i] != null) {
                            summary[i] = inside223[i];

                            y++;
                            if (e2 == y) {
                                break;
                            }
                        }
                    }
                ////////////////////////////////////////////////////// 3rd subpara for more than 10 less than 111
                int jemp = (2 * N5);

                String inside321[] = new String[sent_count];        // the three inside array declaration
                String inside322[] = new String[sent_count];
                String inside323[] = new String[sent_count];


                for (i = 0; i < (sent_count - (2 * N5)); i++)               // the three inside array creation for sub1
                {
                    if (sub2a[i].contains(mst_rep_wrd) && sub2a[i].contains(mst_sec_rep_word)) {
                        j = jemp;
                        inside321[j] = sub2a[i];
                        jemp++;
                    }

                    if (sub2a[i].contains(mst_rep_wrd) && !sub2a[i].contains(mst_sec_rep_word)) {
                        j = jemp;
                        inside322[j] = sub2a[i];
                        jemp++;
                    }

                    if (sub2a[i].contains(mst_sec_rep_word) && !sub2a[i].contains(mst_rep_wrd)) {
                        j = jemp;
                        inside323[j] = sub2a[i];
                        jemp++;
                    }

                    if (!sub2a[i].contains(mst_sec_rep_word) && !sub2a[i].contains(mst_rep_wrd)) {
                        jemp++;
                    }


                }


                int e3 = para_count - (2 * e);
                int y1 = 0;

                if (e2 > y) {
                    e3 = para_count - (2 * e) + (e2 - y);
                }

                for (i = (2 * N5); i < sent_count; i++) {
                    if (inside321[i] != null) {
                        summary[i] = inside321[i];
                        y1++;
                        if (e3 == y1) {
                            break;
                        }
                    }
                }


                if (e3 > y1)
                    for (i = (2 * N5); i < sent_count; i++) {
                        if (inside322[i] != null) {
                            summary[i] = inside322[i];

                            y1++;
                            if (e3 == y1) {
                                break;
                            }

                        }

                    }


                if (e3 > y1)
                    for (i = (2 * N5); i < sent_count; i++) {
                        if (inside323[i] != null) {
                            summary[i] = inside323[i];

                            y1++;
                            if (e3 == y1) {
                                break;
                            }
                        }
                    }


                //////////////////////////////////////// last array for summary

                int hemp = 0;


                for (i = 0; i < sent_count; i++) {
                    if (summary[i] != null) {
                        j = hemp;
                        bc[j] = summary[i];
                        hemp++;

                        if (hemp == para_count) {
                            break;

                        }
                    }
                }


                for (i = 0; i < para_count; i++) {
                    if ((bc[i]) != null) {
                        output = output.concat(bc[i]);
                    }
                }


                intent.putExtra(Data_Key, output);
                startActivity(intent);

            }
        }
    }
    public void CameraBtn(View views){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

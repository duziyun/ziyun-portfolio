/* Generated By:JavaCC: Do not edit this line. MyRelation.java */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
public class MyRelation implements MyRelationConstants {
  public static Relation getparseresult(String args,HashMap<String,Relation> relations) throws Exception
  {
    MyRelation parse = new MyRelation(new java.io.StringReader(args));
    Relation r = parse.Query(relations);
    return r;
  }

  final public Relation Query(HashMap<String,Relation> relations) throws ParseException {
    trace_call("Query");
    try {
  Relation query= null;
  Relation set=null;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RENAME:
        set = SetClause(relations);
        label_1:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case SIGMA:
          case PI:
          case Y:
          case RENAME:
          case OPEN_PAR:
          case NAME:
            ;
            break;
          default:
            jj_la1[0] = jj_gen;
            break label_1;
          }
          query = Query(relations);
        }
        jj_consume_token(0);
     {if (true) return Relation.rename(set,query);}
        break;
      case SIGMA:
      case PI:
      case Y:
      case OPEN_PAR:
      case NAME:
        query = SuperRelation(relations);
        jj_consume_token(0);
    {if (true) return query;}
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Query");
    }
  }

  final public Relation SetClause(HashMap<String,Relation> relations) throws ParseException {
    trace_call("SetClause");
    try {
  ArrayList<String> rename=new ArrayList<String>();
  Relation exp = null;
  Relation stored = null;
      rename = RenameClause();
      exp = SuperRelation(relations);
  stored=Relation.storeOneRelation(relations,exp,rename);
  {if (true) return stored;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("SetClause");
    }
  }

  final public Relation SuperRelation(HashMap<String,Relation> relations) throws ParseException {
    trace_call("SuperRelation");
    try {
  Relation exp1 = null;
  Relation exp2 = null;
  ArrayList<ArrayList<ArrayList<String>>> select = new ArrayList<ArrayList<ArrayList<String>>>();
  ArrayList<ArrayList<ArrayList<String>>> join=new ArrayList<ArrayList<ArrayList<String>>>();
  ArrayList<ArrayList< String>> proj=new ArrayList<ArrayList< String>>();
  ArrayList<String> groupby=new ArrayList<String>();
  ArrayList<ArrayList< String>> functions=new ArrayList<ArrayList< String>>();
  Relation temp=null;
      if (jj_2_1(3)) {
        jj_consume_token(OPEN_PAR);
        exp1 = SuperRelation(relations);
        jj_consume_token(CLOSE_PAR);
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case JOIN:
          case CARTPROD:
          case INTERSECTION:
          case UNION:
          case MINUS:
          case DIVIDE:
            ;
            break;
          default:
            jj_la1[2] = jj_gen;
            break label_2;
          }
          join = JoinCardiClause();
          exp2 = SuperRelation(relations);
        }
     {if (true) return Relation.joinclause(exp1,exp2,join);}
      } else if (jj_2_2(3)) {
        exp1 = BasicRelationExpression(relations);
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case JOIN:
          case CARTPROD:
          case INTERSECTION:
          case UNION:
          case MINUS:
          case DIVIDE:
            ;
            break;
          default:
            jj_la1[3] = jj_gen;
            break label_3;
          }
          join = JoinCardiClause();
          exp2 = SuperRelation(relations);
        }
     {if (true) return Relation.joinclause(exp1,exp2,join);}
      } else if (jj_2_3(3)) {
        select = SelectClause();
        jj_consume_token(OPEN_PAR);
        exp1 = SuperRelation(relations);
        jj_consume_token(CLOSE_PAR);
        label_4:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case JOIN:
          case CARTPROD:
          case INTERSECTION:
          case UNION:
          case MINUS:
          case DIVIDE:
            ;
            break;
          default:
            jj_la1[4] = jj_gen;
            break label_4;
          }
          join = JoinCardiClause();
          exp2 = SuperRelation(relations);
        }
    temp=Relation.selectmethod(select,exp1);
   {if (true) return Relation.joinclause(temp,exp2,join);}
      } else if (jj_2_4(3)) {
        proj = ProjectClause();
        jj_consume_token(OPEN_PAR);
        exp1 = SuperRelation(relations);
        jj_consume_token(CLOSE_PAR);
        label_5:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case JOIN:
          case CARTPROD:
          case INTERSECTION:
          case UNION:
          case MINUS:
          case DIVIDE:
            ;
            break;
          default:
            jj_la1[5] = jj_gen;
            break label_5;
          }
          join = JoinCardiClause();
          exp2 = SuperRelation(relations);
        }
    temp=Relation.project(proj,exp1);
   {if (true) return Relation.joinclause(temp,exp2,join);}
      } else if (jj_2_5(3)) {
        groupby = GroupbyClause();
        functions = FunctionClause();
        jj_consume_token(OPEN_PAR);
        exp1 = SuperRelation(relations);
        jj_consume_token(CLOSE_PAR);
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case JOIN:
          case CARTPROD:
          case INTERSECTION:
          case UNION:
          case MINUS:
          case DIVIDE:
            ;
            break;
          default:
            jj_la1[6] = jj_gen;
            break label_6;
          }
          join = JoinCardiClause();
          exp2 = SuperRelation(relations);
        }
    temp=Relation.groupby(groupby,functions,exp1);
   {if (true) return Relation.joinclause(temp,exp2,join);}
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("SuperRelation");
    }
  }

  final public ArrayList<String> GroupbyClause() throws ParseException {
    trace_call("GroupbyClause");
    try {
  ArrayList<String>attrilist=new ArrayList<String>();
      if (jj_2_6(3)) {
        jj_consume_token(Y);
        jj_consume_token(OPEN_PAR);
        jj_consume_token(CLOSE_PAR);
   {if (true) return attrilist;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case Y:
          jj_consume_token(Y);
          jj_consume_token(OPEN_PAR);
          attrilist = ListofAttr(attrilist);
          jj_consume_token(CLOSE_PAR);
    {if (true) return attrilist;}
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("GroupbyClause");
    }
  }

  final public ArrayList<ArrayList< String>> FunctionClause() throws ParseException {
    trace_call("FunctionClause");
    try {
  ArrayList<ArrayList< String>> functions=new ArrayList<ArrayList< String>>();
      jj_consume_token(FUNCTION);
      jj_consume_token(OPEN_PAR);
      functions = AllFunctions(functions);
      jj_consume_token(CLOSE_PAR);
    {if (true) return functions;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("FunctionClause");
    }
  }

  final public ArrayList<ArrayList< String>> AllFunctions(ArrayList<ArrayList< String>> list) throws ParseException {
    trace_call("AllFunctions");
    try {
  ArrayList< String> onefunction= new ArrayList< String>();
  ArrayList<ArrayList< String>> list2= new ArrayList<ArrayList< String>>();
  Token functionname;
  Token attri;
      functionname = jj_consume_token(NAME);
      jj_consume_token(OPEN_PAR);
      attri = jj_consume_token(NAME);
      jj_consume_token(CLOSE_PAR);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        jj_consume_token(COMMA);
        list2 = AllFunctions(list);
      }
    onefunction.add(functionname.image);
    onefunction.add(attri.image);
    list.add(onefunction);
    {if (true) return list;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("AllFunctions");
    }
  }

  final public ArrayList<String> RenameClause() throws ParseException {
    trace_call("RenameClause");
    try {
  ArrayList<String> attrilist=new ArrayList<String>();
  Token name;
      if (jj_2_7(3)) {
        jj_consume_token(RENAME);
        name = jj_consume_token(NAME);
        jj_consume_token(OPERATOR);
    attrilist.add(name.image);
    {if (true) return attrilist;}
      } else if (jj_2_8(3)) {
        jj_consume_token(RENAME);
        name = jj_consume_token(NAME);
        jj_consume_token(OPEN_PAR);
        attrilist = ListofAttr(attrilist);
        jj_consume_token(CLOSE_PAR);
        jj_consume_token(OPERATOR);
    Collections.reverse(attrilist);
    attrilist.add(name.image);
    {if (true) return attrilist;}
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("RenameClause");
    }
  }

  final public ArrayList<ArrayList<String>> ProjectClause() throws ParseException {
    trace_call("ProjectClause");
    try {
  ArrayList<ArrayList<String>> project=new ArrayList<ArrayList<String>>();
  ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
      jj_consume_token(PI);
      jj_consume_token(OPEN_PAR);
      project = ProjAttr(list);
      jj_consume_token(CLOSE_PAR);
    {if (true) return project;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ProjectClause");
    }
  }

  final public ArrayList<ArrayList<String>> ProjAttr(ArrayList<ArrayList<String>> list) throws ParseException {
    trace_call("ProjAttr");
    try {
  Token rel;
  Token attr;
  ArrayList<String> element=new ArrayList<String>();
  ArrayList<ArrayList<String>> list2=new ArrayList<ArrayList<String>>();
      if (jj_2_9(2)) {
        rel = jj_consume_token(NAME);
        jj_consume_token(DOT);
        attr = jj_consume_token(NAME);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[9] = jj_gen;
            break label_8;
          }
          jj_consume_token(COMMA);
          list2 = ProjAttr(list);
        }
    element.add(rel.image);
    element.add(attr.image);
    list.add(element);
    {if (true) return list;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NAME:
          attr = jj_consume_token(NAME);
          label_9:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case COMMA:
              ;
              break;
            default:
              jj_la1[10] = jj_gen;
              break label_9;
            }
            jj_consume_token(COMMA);
            list2 = ProjAttr(list);
          }
    element.add(attr.image);
    list.add(element);
    {if (true) return list;}
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ProjAttr");
    }
  }

  final public ArrayList<String> ListofAttr(ArrayList<String> list) throws ParseException {
    trace_call("ListofAttr");
    try {
  Token attr;
  ArrayList<String> list2=new ArrayList<String>();
      attr = jj_consume_token(NAME);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_10;
        }
        jj_consume_token(COMMA);
        list2 = ListofAttr(list);
      }
    list.add(attr.image);
    {if (true) return list;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("ListofAttr");
    }
  }

  final public ArrayList<ArrayList<ArrayList<String>>> SelectClause() throws ParseException {
    trace_call("SelectClause");
    try {
  ArrayList<ArrayList<ArrayList<String>>> allcondilist=new ArrayList<ArrayList<ArrayList<String>>>();
      jj_consume_token(SIGMA);
      jj_consume_token(OPEN_PAR);
      allcondilist = Expressionforjoin(allcondilist);
      jj_consume_token(CLOSE_PAR);
    {if (true) return allcondilist;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("SelectClause");
    }
  }

  final public ArrayList<String> Operator() throws ParseException {
    trace_call("Operator");
    try {
  Token operator;
  ArrayList<String> list=new ArrayList<String>();
  String s1="operator";
      operator = jj_consume_token(OPERATOR);
    list.add(s1);
    list.add(operator.image);
    {if (true) return list;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Operator");
    }
  }

  final public ArrayList<ArrayList<ArrayList<String>>> JoinCardiClause() throws ParseException {
    trace_call("JoinCardiClause");
    try {
  ArrayList<ArrayList<ArrayList<String>>> allcondilist=new ArrayList<ArrayList<ArrayList<String>>>();
  ArrayList<ArrayList<String>> templist2=new ArrayList<ArrayList<String>>();
  ArrayList<String> templist1=new ArrayList<String>();
  String s;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARTPROD:
        jj_consume_token(CARTPROD);
    {if (true) return allcondilist;}
        break;
      case UNION:
        jj_consume_token(UNION);
  s="union";
  templist1.add(s);
  templist2.add(templist1);
  allcondilist.add(templist2);
  {if (true) return allcondilist;}
        break;
      case INTERSECTION:
        jj_consume_token(INTERSECTION);
  s="intersection";
  templist1.add(s);
  templist2.add(templist1);
  allcondilist.add(templist2);
  {if (true) return allcondilist;}
        break;
      case MINUS:
        jj_consume_token(MINUS);
  s="minus";
  templist1.add(s);
  templist2.add(templist1);
  allcondilist.add(templist2);
  {if (true) return allcondilist;}
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
  s="divide";
  templist1.add(s);
  templist2.add(templist1);
  allcondilist.add(templist2);
  {if (true) return allcondilist;}
        break;
      case JOIN:
        jj_consume_token(JOIN);
        jj_consume_token(OPEN_PAR);
        allcondilist = Expressionforjoin(allcondilist);
        jj_consume_token(CLOSE_PAR);
    {if (true) return allcondilist;}
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("JoinCardiClause");
    }
  }

  final public ArrayList<ArrayList<ArrayList<String>>> Expressionforjoin(ArrayList<ArrayList<ArrayList<String>>> allcondilist) throws ParseException {
    trace_call("Expressionforjoin");
    try {
  ArrayList<ArrayList<String>> condilist1= new ArrayList<ArrayList<String>>();
  ArrayList<ArrayList<ArrayList<String>>> condilist2= new ArrayList<ArrayList<ArrayList<String>>>();
      condilist1 = Conditionforjoin();
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_11;
        }
        jj_consume_token(AND);
        condilist2 = Expressionforjoin(allcondilist);
      }
      allcondilist.add(condilist1);
    {if (true) return allcondilist;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Expressionforjoin");
    }
  }

  final public ArrayList<ArrayList<String>> Conditionforjoin() throws ParseException {
    trace_call("Conditionforjoin");
    try {
  ArrayList<ArrayList<String>> conditionlist = new ArrayList<ArrayList<String>>();
  ArrayList<String> left = new ArrayList<String>();
  ArrayList<String> right = new ArrayList<String>();
  ArrayList<String> operator=new ArrayList<String>();
      left = Elementforjoin();
      operator = Operator();
      right = Elementforjoin();
    conditionlist.add(left);
    conditionlist.add(operator);
    conditionlist.add(right);
    {if (true) return conditionlist;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Conditionforjoin");
    }
  }

  final public ArrayList<String> Elementforjoin() throws ParseException {
    trace_call("Elementforjoin");
    try {
  Token rel;
  Token attr;
  ArrayList<String> list=new ArrayList<String>();
  String s1="";
  String s2="";
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGITS:
        rel = jj_consume_token(DIGITS);
   s1="number";
    list.add(s1);
    list.add(rel.image);
  {
  {if (true) return list;}
  }
        break;
      default:
        jj_la1[15] = jj_gen;
        if (jj_2_10(2)) {
          rel = jj_consume_token(NAME);
          jj_consume_token(DOT);
          attr = jj_consume_token(NAME);
   s1="relationname";
   s2="attributename";
    list.add(s1);
    list.add(rel.image);
    list.add(s2);
    list.add(attr.image);
    {if (true) return list;}
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case QUO:
            jj_consume_token(QUO);
            rel = jj_consume_token(NAME);
            jj_consume_token(QUO);
    s1="string";
    list.add(s1);
    list.add(rel.image);
    {if (true) return list;}
            break;
          case NAME:
            rel = jj_consume_token(NAME);
    s1="attributename";
    list.add(s1);
    list.add(rel.image);
    {if (true) return list;}
            break;
          default:
            jj_la1[16] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("Elementforjoin");
    }
  }

  final public Relation BasicRelationExpression(HashMap<String,Relation> relations) throws ParseException {
    trace_call("BasicRelationExpression");
    try {
  Token relationName;
  Relation thisRelation = null;
  Relation followRelation = null;
  ArrayList<ArrayList<ArrayList<String>>> allcondilist=new ArrayList<ArrayList<ArrayList<String>>>();
      relationName = jj_consume_token(NAME);
    thisRelation=Relation.getrelationbyname(relations,relationName.image);
    {if (true) return thisRelation;}
    throw new Error("Missing return statement in function");
    } finally {
      trace_return("BasicRelationExpression");
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(DIVIDE)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_33() {
    if (jj_scan_token(QUO)) return true;
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_3R_31()) return true;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_scan_token(RENAME)) return true;
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_3R_18()) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(RENAME)) return true;
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(OPERATOR)) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_scan_token(Y)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_30()) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(SIGMA)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_scan_token(INTERSECTION)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_13()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_14()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(Y)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  private boolean jj_3R_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) return true;
    }
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_3R_28()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3R_29()) return true;
    }
    return false;
  }

  private boolean jj_3_9() {
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_12()) return true;
    if (jj_scan_token(CLOSE_PAR)) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3_5()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_scan_token(DIGITS)) return true;
    return false;
  }

  private boolean jj_3R_31() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_32()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3R_33()) {
    jj_scanpos = xsp;
    if (jj_3R_34()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_23() {
    if (jj_scan_token(UNION)) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_scan_token(CARTPROD)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(JOIN)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(PI)) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    if (jj_3R_20()) return true;
    return false;
  }

  private boolean jj_3R_34() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public MyRelationTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[17];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10380c0,0x10380c0,0x7b00,0x7b00,0x7b00,0x7b00,0x7b00,0x8000,0x100000,0x100000,0x100000,0x1000000,0x100000,0x7b00,0x20,0x800000,0x1200000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[10];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MyRelation(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyRelation(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyRelationTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MyRelation(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyRelationTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MyRelation(MyRelationTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MyRelationTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      trace_token(token, "");
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
      trace_token(token, " (in getNextToken)");
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[25];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 17; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 25; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled = true;

/** Enable tracing. */
  final public void enable_tracing() {
    trace_enabled = true;
  }

/** Disable tracing. */
  final public void disable_tracing() {
    trace_enabled = false;
  }

  private void trace_call(String s) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Call:   " + s);
    }
    trace_indent = trace_indent + 2;
  }

  private void trace_return(String s) {
    trace_indent = trace_indent - 2;
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Return: " + s);
    }
  }

  private void trace_token(Token t, String where) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Consumed token: <" + tokenImage[t.kind]);
      if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
        System.out.print(": \"" + t.image + "\"");
      }
      System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
    }
  }

  private void trace_scan(Token t1, int t2) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Visited token: <" + tokenImage[t1.kind]);
      if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
        System.out.print(": \"" + t1.image + "\"");
      }
      System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
    }
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 10; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

 }
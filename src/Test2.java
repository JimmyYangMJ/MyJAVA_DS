/**
 * @author ymj
 * @Date： 2020/7/10 11:07
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "<script>select a.utc,a.c_no,a.o_id,a.type,a.source,a.fir_loc,a.sec_loc,b.division,b.s_name" +
                " from fence_fire_recorder a left join config_location b on a.o_id=b.o_id" +
                " where 1=1 " +
                "<if test=\"bUtc!=0 and eUtc!=0\">and a.utc &gt; #{bUtc} and a.utc &lt; #{eUtc} </if>" +
                "<if test=\"division!=null and division!=''\">and b.division=#{division}</if>" +
                "<if test=\"sName!=null and sName!=''\">and b.s_name=#{sName}</if>" +
                "<if test=\"type &gt;= 0 and  type &lt;= 1  \">and a.type=#{type}</if>" +
                "<if test=\"status &gt;= 0 and status &lt;=1\">and b.status=#{status}</if>" +
                "<if test=\"cNo!=null and cNo!=''\">and a.c_no=#{cNo}</if> " +
                " order by a.utc desc</script>";
        System.out.println(s);
    }
}

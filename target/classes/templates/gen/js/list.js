/**
 * Created by zzl on 2017/6/23.
 */
/**生成代码*/
function generator(table_id){

    var tableNames = getSelectedRows(table_id);
    if(tableNames == null){
        return ;
    }
    location.href = "/sys/generator/code?tables=" + JSON.stringify(tableNames);
}

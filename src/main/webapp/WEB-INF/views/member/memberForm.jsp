<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>

    <style>
        .id_ok{
            color:#008000;
            display: none;
        }

        .id_already{
            color:#6A82FB;
            display: none;
        }
    </style>


    <script>


        function execDaumPostcode() {
          new daum.Postcode({
            oncomplete: function(data) {
              // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

              // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
              // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
              var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
              var extraRoadAddr = ''; // 도로명 조합형 주소 변수

              // 법정동명이 있을 경우 추가한다. (법정리는 제외)
              // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
              if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
              }
              // 건물명이 있고, 공동주택일 경우 추가한다.
              if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
              }
              // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
              if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
              }
              // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
              if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
              }

              // 우편번호와 주소 정보를 해당 필드에 넣는다.
              document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
              document.getElementById('roadAddress').value = fullRoadAddr;
              document.getElementById('jibunAddress').value = data.jibunAddress;

              // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
              if(data.autoRoadAddress) {
                //예상되는 도로명 주소에 조합형 주소를 추가한다.
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

              } else if(data.autoJibunAddress) {
                  var expJibunAddr = data.autoJibunAddress;
                  document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
              } else {
                  document.getElementById('guide').innerHTML = '';
              }


            }
          }).open();
        }
        //아이디중복체크 참고
        //https://velog.io/@vipstar-_-/Spring-%EC%8B%A4%EC%8B%9C%EA%B0%84-%EC%95%84%EC%9D%B4%EB%94%94-%EC%A4%91%EB%B3%B5%EC%B2%B4%ED%81%AC-ajax

        <%--function fn_overlapped() {--%>
        <%--    var _id = $("#member_id").val();--%>
        <%--    if (_id == '') {--%>
        <%--        alert("ID를 입력하세요");--%>
        <%--        return;--%>
        <%--    }--%>
        <%--    $.ajax({--%>
        <%--        type: "post",--%>
        <%--        async: false,--%>
        <%--        url: "${contextPath}/member/overlapped.do",--%>
        <%--        dataType: "text",--%>
        <%--        data: {id: _id},--%>
        <%--        success: function (data, textStatus) {--%>
        <%--            if (data == 'false') {--%>
        <%--                alert("사용할 수 있는 ID입니다.");--%>
        <%--                $('#btnOverlapped').prop("disabled", true);--%>
        <%--                $('#member_id').prop("disabled", true);--%>
        <%--                $('#member_id').val(_id);--%>
        <%--            } else {--%>
        <%--                alert("사용할 수 없는 ID입니다.");--%>
        <%--            }--%>
        <%--        },--%>
        <%--        error: function (data, textStatus) {--%>
        <%--            alert("에러가 발생했습니다.");--%>

        <%--        },--%>
        <%--        complete: function (data, textStatus) {--%>
        <%--            //alert("작업을완료 했습니다");--%>
        <%--        }--%>
        <%--    });  //end ajax--%>
        <%--}--%>


       /* function checkId(){
            var member_id = $('#member_id').val(); //id값이 "id"인 입력란의 값을 저장
            $.ajax({
                url:'${contextPath}/member/idCheck.do', //Controller에서 요청 받을 주소
                type:'post', //POST 방식으로 전달
                data:{member_id:member_id},
                success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
                    if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                        $('.id_ok').css("display","inline-block");
                        $('.id_already').css("display", "none");
                    } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                        $('.id_already').css("display","inline-block");
                        $('.id_ok').css("display", "none");
                        // alert("아이디를 다시 입력해주세요");
                        $('#id').val('');
                    }
                },
                error:function(){
                    alert("에러입니다");
                }
            });
        };*/


    </script>
</head>
<body>
${contextPath}
<h3>필수입력사항</h3>
<form action="${contextPath}/member/addMember.do" method="post">
    <div id="detail_table">
        <table>
            <tbody>
            <tr class="dot_line">
<%--                <td class="fixed_join">아이디</td>--%>
    <label >아이디#</label>
                <td>
<%--                    <input type="text" name="member_id" id="member_id" size="20"/>--%>

    <input type="text" id="member_id" name="member_id" oninput = "checkId()" >

                    <!-- id ajax 중복체크 -->
                    <span class="id_ok">사용 가능한 아이디입니다.</span>
                    <span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>

<%--                    <input type="hidden" name="member_id" id="member_id"/>--%>

<%--                    <input type="button" id="btnOverlapped" value="중복체크" onClick="fn_overlapped()"/>--%>
                </td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">비밀번호</td>
                <td><input name="member_pwd" type="password" size="20"/></td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">이름</td>
                <td><input name="member_name" type="text" size="20"/></td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">이메일</td>
                <td><input type="text" name="member_email" size="20"/>

            </tr>
            <tr class="dot_line">
                <td class="fixed_join">연락처</td>
                <td><input name="member_phone" type="text" size="20"/></td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">우편번호</td>
                <td><input name="member_zipcode" type="text" size="20"/></td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">주소</td>
                <td><input name="member_address" type="text" size="20"/></td>
            </tr>
            <tr class="dot_line">
                <td class="fixed_join">상세주소</td>
                <td><input name="member_subaddress" type="text" size="20"/></td>
            </tr>


            <%--<tr class="dot_line">
                <td class="fixed_join">주소</td>
                <td>
                   <input type="text" id="zipcode" name="zipcode" size="10" > <a href="javascript:execDaumPostcode()">우편번호검색</a>
                  <br>
                  <p>
                   지번 주소:<br><input type="text" id="roadAddress"  name="roadAddress" size="50"><br><br>
                  도로명 주소: <input type="text" id="jibunAddress" name="jibunAddress" size="50"><br><br>
                  나머지 주소: <input type="text"  name="namujiAddress" size="50" />
                 <!--   <span id="guide" style="color:#999"></span> -->
                   </p>
                </td>
            </tr>--%>
            </tbody>
        </table>
    </div>
    <div class="clear">
        <br><br>
        <table align=center>
            <tr>
                <td>
                    <input type="submit" value="회원 가입">
                    <input type="reset" value="다시입력">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
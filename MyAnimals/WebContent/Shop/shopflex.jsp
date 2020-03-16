<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">

      var IMP = window.IMP;
      IMP.init('imp91208962');
      
      IMP.request_pay({
          pg : 'html5_inicis',
          pay_method : 'card',
          merchant_uid : 'merchant_' + new Date().getTime(),
          name : '${shopDto.shop_name}',
          amount : ${shopDto.shop_price}*${opt},
          buyer_email : '${memberDto.member_email}',
          buyer_name : '${memberDto.member_name}',
          buyer_tel : '${memberDto.member_phone}',
          buyer_addr : '${memberDto.member_address}',
          buyer_postcode : '123-456',
          m_redirect_url : 'https://www.yourdomain.com/payments/complete'
          
      }, function(rsp) {
          if ( rsp.success ) {
              var msg = '결제가 완료되었습니다.';
              msg += '고유ID : ' + rsp.imp_uid;
              msg += '상점 거래ID : ' + rsp.merchant_uid;
              msg += '결제 금액 : ' + rsp.paid_amount;
              msg += '카드 승인번호 : ' + rsp.apply_num;
              
              location.href='shop.do?command=buylistres&shop_seq=${shopDto.shop_seq}&opt=${opt}&shop_name=${shopDto.shop_name}&shop_content=${shopDto.shop_content}&order_buymoney='+rsp.paid_amount;
          } else {
              var msg = '결제에 실패하였습니다.';
              msg += '에러내용 : ' + rsp.error_msg;
              location.href='shop.do?command=selectList';

          }
          alert(msg);
      });
   
</script>
</head>

<body>

</body>
</html>
package io.github.syske.common.util;

import com.ahdms.es.EsApiStart;
import com.ahdms.es.EsVerifyEngineDeal;
import com.ahdms.es.bean.CertInfo;
import com.ahdms.es.bean.SealInfo;
import com.ahdms.es.bean.SesSignInfo;
import com.ahdms.es.result.VerifyResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ClassName EasySignTest Description TODO
 *
 * @author qq
 * @date 2023/8/8 10:21
 * @since JDK 1.8
 */
public class EasySignTest {
  public static EsVerifyEngineDeal verifyEngineDeal =null;
  static {
    try {
      EsApiStart.initConfig("d:/sign/es-client.properties");
    } catch (IOException e) {
      e.printStackTrace();
    }
    verifyEngineDeal = EsVerifyEngineDeal.getInstance();
  }
  public static void main(String[] args) throws IOException {
    System.out.println(verifySignBySignatureData("d:/sign/demo.pdf","d:/sign/signed-demo.pdf"));
  }
  /**
   * 文件签章验证
   * @param filePath 文件数据
   * @param fileType 文件类型(PDF、OFD)
   * @return
   */
  public static List<VerifyResult<SesSignInfo>> verifySignByFile(String filePath,String fileType) throws IOException {
    byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
    List<VerifyResult<SesSignInfo>> result = verifyEngineDeal.verifySignByFile(fileBytes,fileType);
    return result;
  }

  /**
   * 电子签章数据结构验证
   * @param signPath 电子签章数据
   * @param filePath 原文数据
   * @return
   */
  public static VerifyResult verifySignBySignatureData(String filePath,String signPath) throws IOException {
    byte[] signBytes = Files.readAllBytes(Paths.get(signPath));
    byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
    VerifyResult<SesSignInfo> result = verifyEngineDeal.verifySignBySignatureData(signBytes,fileBytes);
    return result;
  }

  /**
   * 电子印章验证
   * @param eslPath 电子印章数据
   * @return
   */
  public static VerifyResult verifySeal(String eslPath) throws IOException {
    byte[] sealBytes = Files.readAllBytes(Paths.get(eslPath));
    VerifyResult<SealInfo> result = verifyEngineDeal.verifySeal(sealBytes);
    return result;
  }
  /**
   * X509格式证书 验证
   * @param certPath X509格式证书数据
   * @return
   */
  public static VerifyResult verifyX509Cert(String certPath) throws IOException {
    byte[] certBytes = Files.readAllBytes(Paths.get(certPath));
    VerifyResult<CertInfo> result = verifyEngineDeal.verifyX509Cert(certBytes);
    return result;
  }

}

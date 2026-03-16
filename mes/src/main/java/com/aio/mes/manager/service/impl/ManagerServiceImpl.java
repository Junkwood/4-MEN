package com.aio.mes.manager.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aio.mes.manager.mapper.ManagerMapper;
import com.aio.mes.manager.service.ManagerService;
import com.aio.mes.manager.service.ManagerVO;
import com.aio.mes.security.service.LoginUserVO;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	ManagerMapper managerMapper;

	// ===================      bom관리        ===================
	@Override
    public List<ManagerVO> bomProdList(String entMemberCode) {
        
		System.out.println("bomProd List entMemberCode Mapper : " + entMemberCode);
        return managerMapper.bomProdList(entMemberCode);
    }
    
    @Override
    public List<ManagerVO> bomList(String prodCode , String entMemberCode) {
    	
        return managerMapper.bomList(prodCode , entMemberCode);
    }

    @Override
    public List<ManagerVO> showMatList() {
        return managerMapper.showMatList();
    }

    @Override
    public List<ManagerVO> searchMatList(String matName) {
        return managerMapper.searchMatList(matName);
    }

    @Override
    public int insertBom(List<ManagerVO> boms) {
        int count = 0;
        for (ManagerVO bom : boms) {
            String bomCode = getBomCode(bom.getProdCode());
            bom.setBomCode(bomCode);
            count += managerMapper.insertBom(bom);
        }
        return count;
    }

    @Override
    public int updateBom(List<ManagerVO> boms) {
        int count = 0;
        for (ManagerVO bom : boms) {
            count += managerMapper.updateBom(bom);
        }
        return count;
    }

    @Override
    public int deleteBom(List<ManagerVO> boms) {
        int count = 0;
        for (ManagerVO bom : boms) {
            count += managerMapper.deleteBom(bom);
        }
        return count;
    }

	@Override
    public String getBomCode(String prodCode) {
        return managerMapper.getBomCode(prodCode);
    }
	
	
	@Override
	public List<ManagerVO> bomGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.bomGetSearchList("bom.getSearchList", managerVO);
	}
	
	// ===================      거래처관리        ===================
	@Override
	public List<ManagerVO> clientList() {
		return managerMapper.clientList();
	}
	
	@Override
    public String getClientCode() {
        return managerMapper.getClientCode();
    }
	
	@Override
	public int insertClient(List<ManagerVO> clients) {
		
		
		int count = 0;
		
		// 현재 사용자의 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // 인증 정보에서 사용자 정보(LoginUserVO)를 가져옴
        LoginUserVO loggedInUser = (LoginUserVO) authentication.getPrincipal();
        
        // 사용자 정보에서 entMemberCode를 가져옴
        String entMemberCode = loggedInUser.getEntMemberCode();
		
        ManagerVO managerVO =new ManagerVO();
        managerVO.setEntMemberCode(entMemberCode);
		
		for (ManagerVO client : clients) {
			count += managerMapper.insertClient(client);
		}
		return count;
	}

	@Override
	public int updateClient(List<ManagerVO> clients) {
		int count = 0;
		for (ManagerVO client : clients) {
			count += managerMapper.updateClient(client);
		}
		return count;
	}

	@Override
	public int deleteClient(List<ManagerVO> clients) {
		int count = 0;
		for (ManagerVO client : clients) {
			count += managerMapper.deleteClient(client);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> clientGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.clientGetSearchList("client.getSearchList", managerVO);
	}

	// ===================      설비관리        ===================
	@Override
	public List<ManagerVO> facList() {
		return managerMapper.facList();
	}
	
	
	@Override
	public int insertFac(List<ManagerVO> facs) {
		int count = 0;
		for (ManagerVO fac : facs) {
			count += managerMapper.insertFac(fac);
		}
		return count;
	}

	@Override
	public int updateFacBtn(List<ManagerVO> facs) {
		int count = 0;
		for (ManagerVO fac : facs) {
			count += managerMapper.updateFacBtn(fac);
		}
		return count;
	}

	@Override
	public int deleteFac(List<ManagerVO> facs) {
		int count = 0;
		for (ManagerVO fac : facs) {
			count += managerMapper.deleteFac(fac);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> facGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.facGetSearchList("fac.getSearchList", managerVO);
	}

	// ===================      제품관리        ===================
	@Override
	public List<ManagerVO> prodList() {
		return managerMapper.prodList();
	}
	
	@Override
	public int insertProd(List<ManagerVO> prods) {
		int count = 0;
		for (ManagerVO prod : prods) {
			count += managerMapper.insertProd(prod);
		}
		return count;
	}

	@Override
	public int updateProd(List<ManagerVO> prods) {
		int count = 0;
		for (ManagerVO prod : prods) {
			count += managerMapper.updateProd(prod);
		}
		return count;
	}

	@Override
	public int deleteProd(List<ManagerVO> prods) {
		int count = 0;
		for (ManagerVO prod : prods) {
			count += managerMapper.deleteProd(prod);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> prodGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.prodGetSearchList("prod.getSearchList", managerVO);
	}

	
    
	
	// ===================      자재관리        ===================
	@Override
	public List<ManagerVO> materialList() {
		return managerMapper.materialList();
	}

	@Override
	public int insertMat(List<ManagerVO> mats) {
		int count = 0;
		for (ManagerVO mat : mats) {
			count += managerMapper.insertMat(mat);
		}
		return count;
	}

	@Override
	public int updateMat(List<ManagerVO> mats) {
		int count = 0;
		for (ManagerVO mat : mats) {
			count += managerMapper.updateMat(mat);
		}
		return count;
	}

	@Override
	public int deleteMat(List<ManagerVO> mats) {
		int count = 0;
		for (ManagerVO mat : mats) {
			count += managerMapper.deleteMat(mat);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> materialGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.materialGetSearchList("material.getSearchList", managerVO);
	}

	

	
	// ===================      검사기준관리        ===================
	@Override
	public List<ManagerVO> testList(String entMemberCode) {

        
        return managerMapper.testList(entMemberCode);
	}

	@Override
	public int insertTest(List<ManagerVO> tests) {
		int count = 0;
		for (ManagerVO test : tests) {
			count += managerMapper.insertTest(test);
		}
		return count;
	}

	@Override
	public int updateTest(List<ManagerVO> tests) {
		int count = 0;
		for (ManagerVO test : tests) {
			count += managerMapper.updateTest(test);
		}
		return count;
	}

	@Override
	public int deleteTest(List<ManagerVO> tests) {
		int count = 0;
		for (ManagerVO test : tests) {
			count += managerMapper.deleteTest(test);
		}
		return count;
	}

	@Override
	public List<ManagerVO> testGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.testGetSearchList("test.getSearchList", managerVO);
	}

	// ===================      공정관리        ===================
	@Override
	public List<ManagerVO> procList() {
		return managerMapper.procList();
	}

	@Override
	public int insertProc(List<ManagerVO> procs) {
		int count = 0;
		for (ManagerVO proc : procs) {
			count += managerMapper.insertProc(proc);
		}
		return count;
	}

	@Override
	public int updateProc(List<ManagerVO> procs) {
		int count = 0;
		for (ManagerVO proc : procs) {
			count += managerMapper.updateProc(proc);
		}
		return count;
	}

	@Override
	public int deleteProc(List<ManagerVO> procs) {
		int count = 0;
		for (ManagerVO proc : procs) {
			count += managerMapper.deleteProc(proc);
		}
		return count;
	}
	
	@Override
	public List<ManagerVO> procGetSearchList(ManagerVO managerVO) throws Exception {
		return managerMapper.procGetSearchList("proc.getSearchList", managerVO);
	}
	
	@Override
	public List<ManagerVO> procOptionList() {
		return managerMapper.procOptionList();
	}
	
	
	
	@Override
	public List<ManagerVO> facOptionList() {
		return managerMapper.facOptionList();
	}
	@Override
	public List<ManagerVO> matOptionList() {
		return managerMapper.matOptionList();
	}
	
	@Override
	public List<ManagerVO> clientOptionList() {
		return managerMapper.clientOptionList();
	}
	
	
	
	
	
	
	
	// application.properties 파일에서 Windows 경로를 읽어옵니다.
    @Value("${upload.path.windows}")
    private String uploadPathWindows;

    // application.properties 파일에서 Linux 경로를 읽어옵니다.
    @Value("${upload.path.linux}")
    private String uploadPathLinux;

    // 현재 운영체제에 맞는 업로드 경로를 반환합니다.
    private String getUploadPath() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win") ? uploadPathWindows : uploadPathLinux;
    }

    @Override
    public List<String> uploadFacImages(MultipartFile[] uploadFiles, String facCode) throws IOException {
        List<String> fileList = new ArrayList<>();
        // 운영체제에 맞는 업로드 디렉토리를 가져옵니다.
        String uploadDir = getUploadPath();

        for (MultipartFile uploadFile : uploadFiles) {
            // 파일의 원본 이름을 가져옵니다.
            String originalName = uploadFile.getOriginalFilename();
            // 파일 이름에서 경로를 제거합니다.
            String fileName = originalName != null ? originalName.substring(originalName.lastIndexOf("\\") + 1) : null;
            // 파일 확장자를 가져옵니다.
            String fileExt = originalName != null ? originalName.substring(originalName.lastIndexOf(".") + 1) : null;
            // 파일 이름에 UUID를 추가하여 고유한 이름을 만듭니다.
            String uuid = UUID.randomUUID().toString();
            String uploadFileName = uuid + "_" + fileName;
            // 저장할 파일의 전체 경로를 만듭니다.
            String saveName = uploadDir + File.separator + uploadFileName;
            saveName = saveName.replace("\\", "/");
            Path savePath = Paths.get(saveName);

            // 파일 경로가 존재하지 않으면 생성합니다.
            if (!Files.exists(savePath.getParent())) {
                Files.createDirectories(savePath.getParent());
            }
            // 파일을 저장합니다.
            uploadFile.transferTo(savePath);

            // URL을 반환할 때는 절대 경로가 아닌 상대 경로로 반환합니다.
            String imageUrl = "/facImages/" + uploadFileName;
            fileList.add(imageUrl);
            imageUrl = imageUrl.replace("\\", "/");

            // 파일 정보를 DB에 저장합니다.
            ManagerVO managerVO = new ManagerVO();
            managerVO.setFileName(fileName);
            managerVO.setFileLocation(saveName);
            managerVO.setFileSize((int) uploadFile.getSize());
            managerVO.setFileExt(fileExt);
            managerVO.setFacCode(facCode);
            managerVO.setImage(imageUrl);
            managerVO.setUploadPath(saveName);
            managerMapper.updateFac(managerVO);
        }

        return fileList;
    }

    @Override
    public ResponseEntity<Object> facImageDownloadFile(String downloadLocation) {
        try {
            Path filePath = Paths.get(downloadLocation);
            Resource resource = new InputStreamResource(Files.newInputStream(filePath));
            File file = new File(downloadLocation);
            // 파일 이름에서 UUID를 제거하고 원래 파일 이름을 가져옵니다.
            String makeName = URLEncoder.encode(file.getName(), "UTF-8");
            String[] nameAry = makeName.split("_");
            String downName = nameAry[1];
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", downName);
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
    
    @Override
	public List<ManagerVO> searchProcList(ManagerVO managerVO) throws Exception {
		return managerMapper.searchProcList("test.getSearchList", managerVO);
	}
		
	
}

package com.hyundairoad.hyundairoad.image.domain.controller;

//@RestController
//@RequestMapping(value = "/api/files", produces = "application/json;charset=UTF-8")
//@RequiredArgsConstructor
//public class ImageController {
//
//    private final ImageService fileService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            String newFilename = fileService.uploadFile(file);
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "File uploaded successfully");
//            response.put("newFilename", newFilename);
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "File upload failed: " + e.getMessage()));
//        }
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<String>> listUploadedFiles() {
//        try {
//            List<String> fileNames = fileService.listUploadedFiles();
//            return ResponseEntity.ok(fileNames);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/info/{filename}")
//    public ResponseEntity<ImageDto> getFileInformation(@PathVariable String filename) {
//        try {
//            ImageDto fileInfo = fileService.getFileInformation(filename);
//            return ResponseEntity.ok(fileInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    @GetMapping("/download/{filename}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
//        try {
//            Resource resource = fileService.downloadFile(filename);
//            String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8.toString()).replace("+", "%20");
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"; filename*=UTF-8''" + encodedFilename)
//                    .body(resource);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//}

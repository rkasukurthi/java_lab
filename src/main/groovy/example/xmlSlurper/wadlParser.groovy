


  def APPLICATION = '''
<resources base="http://esl.silanis.com:8080/aws/rest/">
<resource path="/documents">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="provider"/>
<method name="GET" id="getDocuments">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="refresh"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{provider}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="provider"/>
<method name="GET" id="getProviderDocuments">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="refresh"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{guid}/evidence/summary">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="GET" id="getProcess">
<response>
<representation mediaType="application/pdf"/>
</response>
</method>
</resource>
<resource path="/packages">
<method name="GET" id="getPackages">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="query"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="type"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="search"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="searchtype"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="predefined"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="visibility"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="lastUpdatedStartDate"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="lastUpdatedEndDate"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="sort"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="dir"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:boolean" style="query" name="summary"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="create">
<request>
<representation mediaType="multipart/form-data"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="create">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{guid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="DELETE" id="deleteProcess">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="updateProcessData">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="updateProcessDataViaPut">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getPackage">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{guid}/signingStatus">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="GET" id="getProcessSigningStatus">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="signer"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="document"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{guid}/clone">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="clone">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/session">
<method name="GET" id="getCurrentSession">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="preferences">
<method name="PUT" id="updatePreferences">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{guid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="addSessionProcess">
<request>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/apiKey">
<method name="GET" id="getApiToken">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{packageId}/roles/{roleId}/signingUrl">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="GET" id="getUrl">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{guid}/documents">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="uploadDocument">
<request>
<representation mediaType="multipart/form-data"/>
</request>
<response>
<representation mediaType="text/html"/>
</response>
</method>
<method name="POST" id="addDocumentWithExternalContent">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="orderDocuments">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{documentId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="GET" id="getProcessDocument">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="updateDocumentData">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteProcessDocument">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{documentId}/accept/{approvalId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="approvalId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="acceptDisclosure">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{documentId}/original">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="GET" id="getOriginalDocumentContent">
<response>
<representation mediaType="application/pdf"/>
</response>
</method>
</resource>
<resource path="/{documentId}/pdf">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="GET" id="getProcessDocumentContent">
<response>
<representation mediaType="application/pdf"/>
</response>
</method>
</resource>
<resource path="zip">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="GET" id="getProcessDocumentsContent">
<response>
<representation mediaType="application/zip"/>
</response>
</method>
</resource>
<resource path="/{documentId}/actions">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="confirmDocument">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{documentId}/fields">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="addQrCode">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="updateLayout">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{documentId}/fields/{fieldName}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="fieldName"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="PUT" id="modifyQrCode">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getQrCode">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteQrCode">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{documentId}/layout">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="applyLayout">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="layoutName"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="layoutId"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/signConfirm">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="signAndConfirmDocument">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/fastTrack">
<method name="GET" id="getFastTrackDetails">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="token"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="startFastTrack">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="token"/>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{packageId}/qr">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="GET" id="getQrCode">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:boolean" style="query" name="signing"/>
</request>
<response>
<representation mediaType="image/png"/>
</response>
</method>
</resource>
<resource path="/{packageId}/url">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="GET" id="getUrl">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:boolean" style="query" name="signing"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/account/customfields">
<method name="POST" id="createCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="updateCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getCustomFields">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="dir"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="to"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{customFieldId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="customFieldId"/>
<method name="DELETE" id="deleteCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{guid}/attachment/">
<resource path="/{attachmentUid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="attachmentUid"/>
<method name="POST" id="uploadAttachmentContent">
<request>
<representation mediaType="multipart/form-data"/>
</request>
<response>
<representation mediaType="text/html"/>
</response>
</method>
<method name="GET" id="downloadAttachmentContent">
<response>
<representation mediaType="*/*"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{packageId}/reminders">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="POST" id="createPackageReminderWithSchedule">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deletePackageReminderWithSchedule">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="updatePackageReminderWithSchedule">
<request>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getPackageReminder">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/users">
<method name="GET" id="getUsers">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="refresh"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{provider}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="provider"/>
<method name="GET" id="getUsersForProvider">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="refresh"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/plans">
<method name="GET" id="getPlans">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{planUid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="planUid"/>
<method name="GET" id="getPlan">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/account">
<method name="POST" id="updateAccount">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getAccount">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/senders">
<method name="GET" id="getSenders">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="search"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="sort"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="dir"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="createSender">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/senders/{senderUid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="senderUid"/>
<method name="GET" id="getSenders">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/support">
<method name="GET" id="getSupportConfiguration">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="senders/{senderUid}/invite">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="senderUid"/>
<method name="POST" id="inviteUsers">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="senders/{senderUid}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="senderUid"/>
<method name="POST" id="updateUser">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteSender">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="senders/{senderUid}/password">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="senderUid"/>
<method name="POST" id="updateSenderPassword">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/senders/{senderUid}/resetpassword">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="senderUid"/>
<method name="POST" id="resetUserPassword">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="purchaserequest">
<method name="POST" id="purchaserequest">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/groups">
<method name="GET" id="getGroups">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="dir"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="createGroup">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{groupId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="groupId"/>
<method name="PUT" id="updateGroup">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteGroup">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getGroup">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{groupId}/invite">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="groupId"/>
<method name="POST" id="inviteMember">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{groupId}/members">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="groupId"/>
<method name="POST" id="addMember">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{packageId}/auth">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="GET" id="getAuth">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/challenges">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="POST" id="authenticateChallenges">
<request>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/user/customfields">
<method name="PUT" id="updateUserCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getUserCustomFields">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="createUserCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{customFieldId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="customFieldId"/>
<method name="GET" id="getUserCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteUserCustomField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/authenticationTokens">
<method name="POST" id="create">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{packageGuid}/fieldSummary">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageGuid"/>
<method name="GET" id="exportFieldSummary">
<response>
<representation mediaType="*/*"/>
</response>
</method>
</resource>
<resource path="/packages/{guid}/documents/{documentId}/approvals">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="addApproval">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="updateLayout">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{approvalId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="approvalId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="GET" id="getApproval">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="modifyApproval">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteApproval">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{approvalId}/fields/{fieldId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="fieldId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="approvalId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="saveFieldValue">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="modifyField">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getField">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{approvalId}/sign">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="approvalId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="signTheApproval">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{approvalId}/fields">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="approvalId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="POST" id="addField">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{guid}/documents/{documentId}/pages">
<resource path="/{index}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="template" name="index"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="documentId"/>
<method name="GET" id="getPage">
<response>
<representation mediaType="image/png"/>
</response>
</method>
</resource>
</resource>
<resource path="/packages/{packageId}/notifications">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageId"/>
<method name="POST" id="notifySigner">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{guid}/pagelogs">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="record">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="document"/>
<representation mediaType="application/octet-stream"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/reports">
<resource path="/usage">
<method name="GET" id="getAccountReportBySender">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="to"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getAccountReportBySenderCsv">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="to"/>
</request>
<response>
<representation mediaType="text/csv"/>
</response>
</method>
</resource>
<resource path="/completion">
<method name="GET" id="getSenderReportByPackage">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="senderId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="status"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getSenderReportByPackageCsv">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="senderId"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="status"/>
</request>
<response>
<representation mediaType="text/csv"/>
</response>
</method>
</resource>
</resource>
<resource path="/api-docs">
<method name="GET" id="resourceListing">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{route: .+}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="route"/>
<method name="GET" id="apiDeclaration">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
<resource path="/layouts">
<method name="GET" id="getLayouts">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="query"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="type"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="search"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="searchtype"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="visibility"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="from"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:int" style="query" name="to"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="sort"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="dir"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="POST" id="createLayout">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/ses/listener">
<method name="POST" id="feedback">
<request>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="*/*"/>
</response>
</method>
</resource>
<resource path="/debugdump"/>
<resource path="/signerAuthenticationTokens">
<method name="POST" id="create">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{packageGuid}/audit">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="packageGuid"/>
<method name="GET" id="exportAuditTrail">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="header" name="Accept"/>
</request>
<response>
<representation mediaType="application/xml"/>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/preferences/{id}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="id"/>
<method name="POST" id="updateASignersOwnDetails">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/sessions">
<method name="POST" id="createSession">
<request>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="package"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="signer"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="query" name="inPerson"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/callback">
<method name="POST" id="updateCallbacks">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getCallbacks">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/senderAuthenticationTokens">
<method name="POST" id="create">
<request>
<representation mediaType="*/*"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/packages/{guid}/roles">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<method name="POST" id="addRole">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="PUT" id="orderRoles">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getRoles">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<resource path="/{roleId}/signers">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="POST" id="addUser">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getRoleUsers">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteRoleUsers">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{roleId}">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="PUT" id="updateRole">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="DELETE" id="deleteRole">
<response>
<representation mediaType="application/json"/>
</response>
</method>
<method name="GET" id="getUser">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{roleId}/unlock">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="POST" id="unlockSigner">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{roleId}/notifications">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="POST" id="notifySigner">
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
<resource path="/{roleId}/reassign">
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="guid"/>
<param xmlns:xs="http://www.w3.org/2001/XMLSchema" type="xs:string" style="template" name="roleId"/>
<method name="POST" id="reassignRole">
<request>
<representation mediaType="application/json"/>
</request>
<response>
<representation mediaType="application/json"/>
</response>
</method>
</resource>
</resource>
</resources>
'''
def path =[]

def c
c={
  def n= it.name()
  if (n=='resource')
  {
    path.push(it.'@path')
    it.each(c)
    path.pop()
  }else if (n=='method') {
    println " ${path.join('')}, ${it.'@name'}, ${it.'@id'}"
  }
}

new XmlParser().parseText(APPLICATION).each(c)
